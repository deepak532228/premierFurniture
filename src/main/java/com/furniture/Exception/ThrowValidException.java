package com.furniture.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ThrowValidException extends RuntimeException{
	
	public ThrowValidException(String msg) {
		super(msg);
	}
	
	public ThrowValidException(String message, Throwable cause) {
		super(message, cause);
	}


}
