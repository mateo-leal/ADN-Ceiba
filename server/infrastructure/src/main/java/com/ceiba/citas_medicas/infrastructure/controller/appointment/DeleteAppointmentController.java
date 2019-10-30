package com.ceiba.citas_medicas.infrastructure.controller.appointment;

import com.ceiba.citas_medicas.application.handler.appointment.DeleteAppointmentHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/appointments")
@Api(value = "Appointments", tags = { "appointments" })
public class DeleteAppointmentController {

    private final DeleteAppointmentHandler deleteAppointmentHandler;

    @Autowired
    public DeleteAppointmentController(DeleteAppointmentHandler deleteAppointmentHandler) {
        this.deleteAppointmentHandler = deleteAppointmentHandler;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ApiOperation("Delete an appointment")
    public ResponseEntity<Void> execute(@PathVariable Long id) {
        deleteAppointmentHandler.execute(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
