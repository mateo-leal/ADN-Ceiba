package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.service.client.FindAllClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllClientHandler {

    private final FindAllClientService findAllClientService;

    @Autowired
    public FindAllClientHandler(FindAllClientService findAllClientService) {
        this.findAllClientService = findAllClientService;
    }

    public List<Client> execute() {
        return findAllClientService.execute();
    }
}
