package com.ceiba.citas_medicas.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ClientTest {

    @Test
    void instance_when_numeroDocumento_is_blank() {
        // arrange - act - assert
        assertThatThrownBy(() -> new Client("   ", "John Doe"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void instance_when_nombres_is_blank() {
        // arrange - act - assert
        assertThatThrownBy(() -> new Client("123", "   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void instance_when_correct() {
        // arrange
        var persona = new Client("123", "John Doe");

        // act - assert
        assertThat(persona).isNotNull();
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
        assertThat(persona.getId()).isEqualTo(id);
        assertThat(persona.getFullName()).isEqualTo(nombre);
        assertThat(persona.getDocumentNumber()).isEqualTo(numeroDocumento);
    }

    @Test
    void equals() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        var client2 = new Client(1L, "123", "John Doe");
        // act - assert
        assertThat(client.equals("not the same class")).isFalse();
        assertThat(client.equals(client2)).isTrue();
    }

    @Test
    void hash() {
        final var hashCode = 32;
        final var client = new Client(1L, "123", "John Doe");
        assertThat(client.hashCode()).isEqualTo(hashCode);
    }
}