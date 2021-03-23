package com.cg.onlinepizza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class OnlinePizzaExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception, WebRequest request){
        ErrorMessage error=new ErrorMessage("400",exception.getBindingResult().getFieldError().getDefaultMessage());
       
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);   
    }
	
	@ResponseBody
	@ExceptionHandler(CustomerIdNotFoundException.class)
	ResponseEntity<?> exceptionHandler(CustomerIdNotFoundException ex,WebRequest request){
		ErrorMessage error=new ErrorMessage("400",ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CoupanIdNotFoundException.class)
	public ErrorMessage CoupanIdNotFoundException(CoupanIdNotFoundException ex)
	{
		return new ErrorMessage("400",ex.getMessage());
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCoupanOperationException.class)
	public ErrorMessage InvalidCoupanOperationException(InvalidCoupanOperationException ex)
	{
		return new ErrorMessage("400",ex.getMessage());
	}

}
