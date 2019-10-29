package com.ceiba.citas_medicas.domain.model;

import static com.ceiba.citas_medicas.domain.util.Message.getMessage;
import static com.ceiba.citas_medicas.domain.validation.ArgumentUtils.requireNonBlank;

/**
 * A {@link Client} domain object.
 * @author Mateo Leal
 */
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

    public Long getId() {
        return id;
    }
    public String getDocumentNumber() {
        return documentNumber;
    }
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}