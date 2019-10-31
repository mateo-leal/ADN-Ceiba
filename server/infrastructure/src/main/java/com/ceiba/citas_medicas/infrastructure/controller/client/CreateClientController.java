package com.ceiba.citas_medicas.infrastructure.controller.client;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.handler.appointment.CreateAppointmentHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/appointments")
@Api(value = "Appointments", tags = { "appointments" })
public class CreateAppointmentController {

    private final CreateAppointmentHandler createAppointmentHandler;

    @Autowired
    public CreateAppointmentController(CreateAppointmentHandler createAppointmentHandler) {
        this.createAppointmentHandler = createAppointmentHandler;
    }

    @PostMapping
    @Transactional
    @ApiOperation("Create an appointment")
    public ResponseEntity<Void> execute(@RequestBody AppointmentCommand appointment) {
        createAppointmentHandler.execute(appointment);
        return new ResponseEntity<>(CREATED);
    }
}
