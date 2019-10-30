package com.ceiba.citas_medicas.infrastructure.controller.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {

    private int statusCode;
    private String errorMessage;
}
