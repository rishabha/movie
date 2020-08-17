 package com.pack.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pack.model.ErrorMessage;
import com.pack.model.ResponseMessage;



/**
 * @author Rishabha
 *
 */
@ControllerAdvice
public class APIErrorAdvice {
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> exceptionHandler(Exception ex) {
		ResponseMessage error = new ResponseMessage();
        error.setData(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setError(new ErrorMessage("404","Please contact your administrator"));
        return new ResponseEntity<ResponseMessage>(error, HttpStatus.OK);
    }
    
}
