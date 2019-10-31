package com.ceiba.citas_medicas.infrastructure.controller.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.handler.appointment.FindAllAppointmentHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Appointments", tags = { "appointments" })
public class FindAllAppointmentController {

    private final FindAllAppointmentHandler findAllAppointmentHandler;

    @Autowired
    public FindAllAppointmentController(FindAllAppointmentHandler findAllAppointmentHandler) {
        this.findAllAppointmentHandler = findAllAppointmentHandler;
    }

    @GetMapping
    @ApiOperation("Find all appointments")
    public ResponseEntity<List<AppointmentCommand>> execute() {
        return new ResponseEntity<>(findAllAppointmentHandler.execute(), OK);
    }
}
