package com.ceiba.citas_medicas.infrastructure.controller.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.handler.appointment.FindAppointmentHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ceiba.citas_medicas.infrastructure.config.Constants.FRONT_END_URL;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = FRONT_END_URL)
@Api(value = "Appointments", tags = { "appointments" })
public class FindAppointmentController {

    private final FindAppointmentHandler findAppointmentHandler;

    @Autowired
    public FindAppointmentController(FindAppointmentHandler findAppointmentHandler) {
        this.findAppointmentHandler = findAppointmentHandler;
    }

    @GetMapping("/{id}")
    @ApiOperation("Find an appointment")
    public ResponseEntity<AppointmentCommand> execute(@PathVariable Long id) {
        return findAppointmentHandler.execute(id)
                .map(appointment -> new ResponseEntity<>(appointment, OK))
                .orElseGet(() -> new ResponseEntity<>(NO_CONTENT));
    }
}
