package com.ceiba.citas_medicas.infrastructure.controller;

import com.ceiba.citas_medicas.application.use_case.adapter.CrearCitaUseCaseAdapter;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citas")
@Api("Citas")
public class CitaController {

    private final CrearCitaUseCaseAdapter crearCitaUseCase;

    @Autowired
    public CitaController(CrearCitaUseCaseAdapter crearCitaUseCase) {
        this.crearCitaUseCase = crearCitaUseCase;
    }


}
