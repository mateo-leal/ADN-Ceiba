package com.ceiba.citas_medicas.application.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentCommand implements Serializable {

    private static final long serialVersionUID = 7485296643459028611L;

    @JsonProperty("id")
    private Long id;
    @JsonProperty("appointmentDate")
    @NotNull
    private LocalDateTime appointmentDate;
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
    @JsonProperty("client")
    @Valid
    private ClientCommand client;
}