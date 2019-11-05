package com.ceiba.citas_medicas.infrastructure.controller.appointment;

import com.ceiba.citas_medicas.application.handler.appointment.DeleteAppointmentHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static com.ceiba.citas_medicas.infrastructure.config.Constants.FRONT_END_URL;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = FRONT_END_URL)
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
