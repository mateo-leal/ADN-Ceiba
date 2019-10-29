package com.ceiba.citas_medicas.domain.model;

/**
 * A {@link Persona} domain object.
 * @author Mateo Leal
 */
public class Persona {

    private Long id;
    private String numeroDocumento;
    private String nombres;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}