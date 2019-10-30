package com.ceiba.citas_medicas.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static com.ceiba.citas_medicas.domain.util.Message.getMessage;
import static com.ceiba.citas_medicas.domain.validation.ArgumentUtils.requireNonBlank;

/**
 * A {@link Client} domain object.
 * @author Mateo Leal
 */
@Getter
@EqualsAndHashCode
public class Client {

    private Long id;
    private String documentNumber;
    private String fullName;

    public Client(String documentNumber, String fullName) {
        this(null, documentNumber, fullName);
    }

    public Client(Long id, String documentNumber, String fullName) {
        this.id = id;
        this.documentNumber = requireNonBlank(documentNumber, getMessage("obligatorio.numero-documento"));
        this.fullName = requireNonBlank(fullName, getMessage("obligatorio.nombres"));
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}