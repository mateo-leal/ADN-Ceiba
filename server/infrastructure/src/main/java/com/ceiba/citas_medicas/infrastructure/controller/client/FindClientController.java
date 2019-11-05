package com.ceiba.citas_medicas.infrastructure.controller.client;

import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.application.handler.client.FindClientHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.ceiba.citas_medicas.infrastructure.config.Constants.FRONT_END_URL;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

//@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = FRONT_END_URL)
@Api(value = "Clients", tags = { "clients" })
public class FindClientController {

    private final FindClientHandler findClientHandler;

//    @Autowired
    public FindClientController(FindClientHandler findClientHandler) {
        this.findClientHandler = findClientHandler;
    }

    @GetMapping
    @ApiOperation("Find a client")
    public ResponseEntity<ClientCommand> execute(@RequestParam("documentNumber") String documentNumber) {
        return findClientHandler.execute(documentNumber)
                .map(appointment -> new ResponseEntity<>(appointment, OK))
                .orElseGet(() -> new ResponseEntity<>(NO_CONTENT));
    }
}
