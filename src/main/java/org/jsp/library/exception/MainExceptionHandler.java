package org.jsp.library.exception;

import java.util.InputMismatchException;

import org.jsp.library.repository.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler {

	@ExceptionHandler(SholudNotRepeateException .class)
	public ResponseEntity<ResponseStructure<String>> sholudNotRepeate(SholudNotRepeateException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData(exception.getMessage());
		structure.setMessage("there is exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return  new ResponseEntity<ResponseStructure<String>>(structure ,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InputMismatchException.class)
	public ResponseEntity<ResponseStructure<String>> notFound(InputMismatchException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData(exception.getMessage());
		structure.setMessage("there is exception");
		structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		return  new ResponseEntity<ResponseStructure<String>>(structure ,HttpStatus.NOT_ACCEPTABLE);
	}
}
