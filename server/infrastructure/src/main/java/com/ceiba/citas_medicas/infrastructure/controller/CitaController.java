package com.ceiba.citas_medicas.infrastructure.controller;

import com.ceiba.citas_medicas.application.service.api.CitaService;
import com.ceiba.citas_medicas.domain.model.Cita;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/citas")
@Api("Citas")
public class CitaController {

    private final CitaService service;

    @Autowired
    public CitaController(CitaService service) {
        this.service = service;
    }

    @GetMapping("/")
    ResponseEntity<List<Cita>> findAll() {
        return new ResponseEntity<>(service.findAll(), OK);
    }

    @PostMapping("/")
    ResponseEntity<Cita> save(@RequestBody Cita cita) {
        return new ResponseEntity<>(service.save(cita), OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    ResponseEntity<Cita> find(@PathVariable Long id) {
        return service.find(id)
                .map(cita -> new ResponseEntity<>(cita, OK))
                .orElseThrow(EntityNotFoundException::new);
    }
}
