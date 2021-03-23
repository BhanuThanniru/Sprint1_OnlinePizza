package com.cg.onlinepizza.exceptions;
import java.util.Date;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class CoupanExceptionHandler {
	

	@ResponseBody
	@ExceptionHandler(CoupanIdNotFoundException.class)
	ResponseEntity<?> exceptionHandler(CoupanIdNotFoundException ex,WebRequest request){
		ErrorMessage error=new ErrorMessage("400",ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

	
	@ResponseBody
	@ExceptionHandler(InvalidCoupanOperationException.class)
	ResponseEntity<?> exceptionHandler(InvalidCoupanOperationException ex,WebRequest request){
		ErrorMessage error=new ErrorMessage("400",ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
		@ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception, WebRequest request){
	        ErrorMessage error=new ErrorMessage("400",exception.getBindingResult().getFieldError().getDefaultMessage());
	       
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);   
	    }
	
}



