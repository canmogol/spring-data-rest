package com.guitar.config;

import com.guitar.exception.EntityValidationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerConfiguration {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Invalid Data sent to server")
    public void notValid() {
        System.out.println("ControllerConfiguration.notValid");
    }

    @ExceptionHandler(EntityValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Could not validate entity")
    public void notValidEntity() {
        System.out.println("ControllerConfiguration.notValidEntity");
    }

}
