package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.service.client.FindClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindClientHandler {

    private final FindClientService findClientService;

    @Autowired
    public FindClientHandler(FindClientService findClientService) {
        this.findClientService = findClientService;
    }

    public Optional<Client> execute(Long id) {
        return findClientService.execute(id);
    }
}
