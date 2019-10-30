package com.ceiba.citas_medicas.application.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientCommandTest {

    @Test
    void getters() {
        var command = new ClientCommand();
        assertNull(command.getId());
        assertNull(command.getDocumentNumber());
        assertNull(command.getFullName());
    }
}