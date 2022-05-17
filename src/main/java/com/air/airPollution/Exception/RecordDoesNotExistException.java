package com.air.airPollution.Exception;

public class RecordDoesNotExistException extends RuntimeException{

	public RecordDoesNotExistException (String s) {
		super(s);
	}
	
	public RecordDoesNotExistException (Exception e) {
		super(e);
	}
	
	public RecordDoesNotExistException (String s, Exception e) {
		super(s,e);
	}

}
