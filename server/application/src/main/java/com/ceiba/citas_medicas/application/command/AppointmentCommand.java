package com.ceiba.citas_medicas.application.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentCommand implements Serializable {

    private static final long serialVersionUID = 7485296643459028611L;

    @NonNull
    @JsonProperty("id")
    private Long id;
    @NonNull
    @JsonProperty("appointmentDate")
    private LocalDateTime appointmentDate;
    @NonNull
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
    @JsonProperty("price")
    private Double price;
    @NonNull
    @JsonProperty("client")
    private ClientCommand client;
}