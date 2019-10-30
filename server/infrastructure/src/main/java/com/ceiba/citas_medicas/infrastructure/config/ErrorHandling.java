package com.ceiba.citas_medicas.infrastructure.config;

import com.ceiba.citas_medicas.domain.exception.PersistenceException;
import com.ceiba.citas_medicas.infrastructure.controller.command.ErrorMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Log4j2
@ControllerAdvice
public class ErrorHandling {

    @ExceptionHandler({ PersistenceException.class })
    public ResponseEntity<ErrorMessage> handlePersistenceException(PersistenceException e) {
        log.error(e.getMessage(), e);
        return error(BAD_REQUEST, e);
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e.getMessage());
        return error(BAD_REQUEST, e);
    }

    private ResponseEntity<ErrorMessage> error(HttpStatus status, Throwable e) {
        var errorMessage = ErrorMessage.builder().statusCode(status.value()).errorMessage(e.getMessage()).build();
        return ResponseEntity.status(status).body(errorMessage);
    }
}
