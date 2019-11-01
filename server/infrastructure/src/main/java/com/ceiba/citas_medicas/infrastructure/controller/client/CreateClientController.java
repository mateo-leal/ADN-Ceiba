package com.ceiba.citas_medicas.infrastructure.controller.client;

import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.application.handler.client.CreateClientHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static com.ceiba.citas_medicas.infrastructure.config.Constants.FRONT_END_URL;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = FRONT_END_URL)
@Api(value = "Clients", tags = { "clients" })
public class CreateClientController {

    private final CreateClientHandler createClientHandler;

    @Autowired
    public CreateClientController(CreateClientHandler createClientHandler) {
        this.createClientHandler = createClientHandler;
    }

    @PostMapping
    @Transactional
    @ApiOperation("Create a client")
    public ResponseEntity<Void> execute(@RequestBody ClientCommand clientCommand) {
        createClientHandler.execute(clientCommand);
        return new ResponseEntity<>(CREATED);
    }
}
