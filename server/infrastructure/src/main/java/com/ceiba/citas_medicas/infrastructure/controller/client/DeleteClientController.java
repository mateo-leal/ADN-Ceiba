package com.ceiba.citas_medicas.infrastructure.controller.client;

import com.ceiba.citas_medicas.application.handler.client.DeleteClientHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static com.ceiba.citas_medicas.infrastructure.config.Constants.FRONT_END_URL;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = FRONT_END_URL)
@Api(value = "Clients", tags = { "clients" })
public class DeleteClientController {

    private final DeleteClientHandler deleteClientHandler;

    @Autowired
    public DeleteClientController(DeleteClientHandler deleteClientHandler) {
        this.deleteClientHandler = deleteClientHandler;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ApiOperation("Delete a client")
    public ResponseEntity<Void> execute(@PathVariable Long id) {
        deleteClientHandler.execute(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
