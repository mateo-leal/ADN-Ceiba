package com.ceiba.citas_medicas.application.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
    private LocalDateTime appointmentDate;
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("client")
    private ClientCommand client;

    public AppointmentCommand(Long id, LocalDateTime appointmentDate, LocalDateTime createdAt, ClientCommand client) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.createdAt = createdAt;
        this.client = client;
    }
}