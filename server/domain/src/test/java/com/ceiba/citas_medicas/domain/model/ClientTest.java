package com.ceiba.citas_medicas.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void instance_when_numeroDocumento_is_blank() {
        // arrange - act - assert
        assertThrows(IllegalArgumentException.class, () -> new Client("   ", "John Doe"));
    }

    @Test
    void instance_when_nombres_is_blank() {
        // arrange - act - assert
        assertThrows(IllegalArgumentException.class, () -> new Client("123", "   "));
    }

    @Test
    void instance_when_correct() {
        // arrange
        var persona = new Client("123", "John Doe");

        // act - assert
        assertNotNull(persona);
    }

    @Test
    void getter_setter() {
        // arrange
        var id = 1L;
        var numeroDocumento = "123";
        var nombre = "John Doe";
        var persona = new Client(id, numeroDocumento, nombre);

        // act
        persona.setFullName(nombre);
        persona.setDocumentNumber(numeroDocumento);

        // assert
        assertEquals(id, persona.getId());
        assertEquals(nombre, persona.getFullName());
        assertEquals(numeroDocumento, persona.getDocumentNumber());
    }

    @Test
    void equals() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        // act - assert
        assertFalse(client.equals("not the same class"));
    }

    @Test
    void hash() {
        final var hashCode = 32;
        final var client = new Client(1L, "123", "John Doe");
        assertEquals(hashCode, client.hashCode());
    }
}