package com.ceiba.citas_medicas.application.command;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientCommandTest {

    @Test
    void getters() {
        var command = new ClientCommand();
        assertThat(command.getId()).isNull();
        assertThat(command.getDocumentNumber()).isNull();
        assertThat(command.getFullName()).isNull();
    }

    @Test
    void one_arg_constructor() {
        var command = new ClientCommand("123");
        assertThat(command.getId()).isNull();
        assertThat(command.getDocumentNumber()).isNotNull();
        assertThat(command.getFullName()).isNull();
    }

    @Test
    void equals() {
        var command = new ClientCommand(1L, "123", "John Doe");
        var command2 = new ClientCommand(1L, "123", "John Doe");
        assertThat(command.equals(command2)).isTrue();
    }
}