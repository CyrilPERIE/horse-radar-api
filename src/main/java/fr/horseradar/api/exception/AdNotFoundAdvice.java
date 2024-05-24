package fr.horseradar.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdNotFoundAdvice {
	
	@ExceptionHandler(AdNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String adNotFoundHandler(AdNotFoundException ex) {
	    return ex.getMessage();
	  }

}
