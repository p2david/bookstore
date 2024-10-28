package com.patricio.bookstore.resources.exceptional;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.patricio.bookstore.services.exceptions.ObjectNotFoundExcepion;
import com.sun.xml.bind.api.impl.NameConverter.Standard;

@ControllerAdvice
public class ResourceExceptionHandler {

@ExceptionHandler(ObjectNotFoundExcepion.class)
public ResponseEntity<StandardError> ObjectNotFoundException(ObjectNotFoundExcepion e, ServletRequest request){
	
	StandardError error = new StandardError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(), e.getMessage());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
}
}
