package com.ceiba.citas_medicas.infrastructure.controller.command;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class ErrorMessage {

    private HttpStatus statusCode;
    private String errorMessage;
}
