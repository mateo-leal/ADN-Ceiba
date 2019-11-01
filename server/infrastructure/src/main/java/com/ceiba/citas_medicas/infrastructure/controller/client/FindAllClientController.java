package com.ceiba.citas_medicas.infrastructure.controller.client;

import com.ceiba.citas_medicas.application.handler.client.FindAllClientHandler;
import com.ceiba.citas_medicas.application.handler.client.FindClientHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ceiba.citas_medicas.infrastructure.config.Constants.FRONT_END_URL;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = FRONT_END_URL)
@Api(value = "Clients", tags = { "clients" })
public class FindAllClientController {

    private final FindAllClientHandler findAllClientHandler;
    private final FindClientHandler findClientHandler;

    @Autowired
    public FindAllClientController(FindAllClientHandler findAllClientHandler,
                                   FindClientHandler findClientHandler) {
        this.findAllClientHandler = findAllClientHandler;
        this.findClientHandler = findClientHandler;
    }

    @GetMapping
    @ApiOperation("Find all appointments")
    public ResponseEntity execute(String documentNumber) {
        if (documentNumber != null) {
            return findClientHandler.execute(documentNumber)
                    .map(appointment -> new ResponseEntity<>(appointment, OK))
                    .orElseGet(() -> new ResponseEntity<>(NO_CONTENT));
        }
        return new ResponseEntity<>(findAllClientHandler.execute(), OK);
    }
}
