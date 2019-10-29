package com.ceiba.citas_medicas.infrastructure.controller.appointment.config;

import com.ceiba.citas_medicas.domain.exception.PersistenceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ErrorHandling {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({ PersistenceException.class })
    public void handle(PersistenceException e) {}
}
