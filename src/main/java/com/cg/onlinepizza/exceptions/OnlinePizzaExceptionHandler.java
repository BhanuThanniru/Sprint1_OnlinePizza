package com.cg.onlinepizza.exceptions;

import java.net.http.HttpHeaders;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class OnlinePizzaExceptionHandler {


	@ResponseBody
	@ExceptionHandler(PizzaIdNotFoundException.class)
	ResponseEntity<?> exceptionHandler(PizzaIdNotFoundException exception,WebRequest request){
		ErrorMessage error=new ErrorMessage("404",exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(PizzaTypeNotFoundExcpetion.class)
	ResponseEntity<?> exceptionHandler(PizzaTypeNotFoundExcpetion exception,WebRequest request){
		ErrorMessage error=new ErrorMessage("404",exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

	@ResponseBody
	@ExceptionHandler(OrderIdNotFoundException.class)
	ResponseEntity<?> exceptionHandler(OrderIdNotFoundException exception,WebRequest request){
		ErrorMessage error=new ErrorMessage("404",exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}


	@ResponseBody
	@ExceptionHandler(CustomerIdNotFoundException.class)
	ResponseEntity<?> exceptionHandler(CustomerIdNotFoundException exception,WebRequest request){
		ErrorMessage error=new ErrorMessage("404",exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(CoupanIdNotFoundException.class)
	ResponseEntity<?> exceptionHandler(CoupanIdNotFoundException exception,WebRequest request){
		ErrorMessage error=new ErrorMessage("404",exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidCoupanOperationException.class)
	ResponseEntity<?> exceptionHandler(InvalidCoupanOperationException exception,WebRequest request){
		ErrorMessage error=new ErrorMessage("400",exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@ExceptionHandler(InvalidSizeException.class)
	ResponseEntity<?> exceptionHandler(InvalidSizeException exception,WebRequest request){
		ErrorMessage error=new ErrorMessage("400",exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

	//handling validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception, WebRequest request){
		ErrorMessage error=new ErrorMessage("400",exception.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);	
	}

}




/*
 * @ResponseBody
 * 
 * @ResponseStatus(HttpStatus.BAD_REQUEST)
 * 
 * @ExceptionHandler({PizzaIdNotFoundException.class}) public ErrorMessage
 * PizzaIdNotFoundException(PizzaIdNotFoundException exception) { return new
 * ErrorMessage("400", exception.getMessage()); }
 */

