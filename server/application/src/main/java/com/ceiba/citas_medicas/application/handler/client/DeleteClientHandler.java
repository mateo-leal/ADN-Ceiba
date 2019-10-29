package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.domain.service.client.DeleteClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientHandler {

    private final DeleteClientService deleteClientService;

    @Autowired
    public DeleteClientHandler(DeleteClientService deleteClientService) {
        this.deleteClientService = deleteClientService;
    }

    public void execute(Long id) {
        deleteClientService.execute(id);
    }
}
