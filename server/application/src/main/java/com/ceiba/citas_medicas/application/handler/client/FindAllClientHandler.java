package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.application.command.factory.ClientFactory;
import com.ceiba.citas_medicas.domain.service.client.FindAllClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllClientHandler {

    private final FindAllClientService findAllClientService;

    @Autowired
    public FindAllClientHandler(FindAllClientService findAllClientService) {
        this.findAllClientService = findAllClientService;
    }

    public List<ClientCommand> execute() {
        return findAllClientService.execute().stream()
                .map(ClientFactory::toCommand)
                .collect(Collectors.toList());
    }
}
