package com.ceiba.citas_medicas.application.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    @JsonProperty("documentNumber")
    private String documentNumber;
    @NotBlank
    @JsonProperty("fullName")
    private String fullName;
}