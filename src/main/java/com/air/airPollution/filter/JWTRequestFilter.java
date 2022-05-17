package com.air.airPollution.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.air.airPollution.model.Response;
import com.air.airPollution.service.SampleUSerDetailsService;
import com.air.airPollution.service.UserRegistrationService;
import com.air.airPollution.util.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JWTRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private UserRegistrationService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 final String authorizationHeader = request.getHeader("Authorization");

	        String username = null;
	        String jwt = null;
	        
	        System.out.println();
	        
			if (!(request.getRequestURI().equals("/usersignUp") || request.getRequestURI().equals("/userlogin")
					|| request.getRequestURI().equals("/adminlogin"))) {
	        
	        try {
	        	if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
		            jwt = authorizationHeader.substring(7);
		            username = jwtUtil.extractUsername(jwt);
		        }
		        else {
		        	throw new Exception("Authorization header not found");
		        }


		        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

		        	
		            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

		            if (jwtUtil.validateToken(jwt, userDetails)) {

		                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
		                        userDetails, null, userDetails.getAuthorities());
		                usernamePasswordAuthenticationToken
		                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		            }
		            else {
		            	throw new Exception("Token is invalid");
		            }
		     
		        }
		        
		        filterChain.doFilter(request, response);
		        
	        	
	        }catch (Exception e) {
	        		Response customResponse = new Response("FAILURE",e.getMessage());
	        		response.setContentType("application/json");
	        		response.setStatus(403);
	        		response.getWriter().write(mapper.writeValueAsString(customResponse));
			}
	        
	}
	        else {
	        	filterChain.doFilter(request, response);
	        }
	        
	        

	        
	}

}
