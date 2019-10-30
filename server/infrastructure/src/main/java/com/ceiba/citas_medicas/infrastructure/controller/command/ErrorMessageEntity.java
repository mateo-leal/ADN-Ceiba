package com.ceiba.citas_medicas.infrastructure.controller.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessageEntity {

    private int statusCode;
    private String errorMessage;
}
