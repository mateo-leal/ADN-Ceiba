package com.ceiba.citas_medicas.application.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientCommand implements Serializable {

    private static final long serialVersionUID = -4214433336935139060L;

    @JsonProperty("id")
    private Long id;
    @JsonProperty("documentNumber")
    private String documentNumber;
    @JsonProperty("fullName")
    private String fullName;

    public ClientCommand(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}