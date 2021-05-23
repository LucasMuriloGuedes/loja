package com.lucasmurilo.loja.resources.exceptions;

import com.lucasmurilo.loja.services.exceptions.DataBaseExcption;
import com.lucasmurilo.loja.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourcesExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status, error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(DataBaseExcption.class)
    public ResponseEntity<StandardError> dataBase(DataBaseExcption e, HttpServletRequest request){
        String error = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status, error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

}
