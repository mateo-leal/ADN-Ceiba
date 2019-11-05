package com.ceiba.citas_medicas.infrastructure.controller.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.application.handler.appointment.FindAllAppointmentHandler;
import com.ceiba.citas_medicas.application.handler.appointment.FindByClientAppoinmentHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ceiba.citas_medicas.infrastructure.config.Constants.FRONT_END_URL;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = FRONT_END_URL)
@Api(value = "Appointments", tags = { "appointments" })
public class FindAllAppointmentController {

    private final FindAllAppointmentHandler findAllAppointmentHandler;
    private final FindByClientAppoinmentHandler findByClientAppoinmentHandler;

    @Autowired
    public FindAllAppointmentController(FindAllAppointmentHandler findAllAppointmentHandler,
                                        FindByClientAppoinmentHandler findByClientAppoinmentHandler) {
        this.findAllAppointmentHandler = findAllAppointmentHandler;
        this.findByClientAppoinmentHandler = findByClientAppoinmentHandler;
    }

    @GetMapping
    @ApiOperation("Find all appointments")
    public ResponseEntity<List<AppointmentCommand>> execute(String clientDocumentNumber) {
        if (clientDocumentNumber != null) {
            var clientCommand = new ClientCommand(clientDocumentNumber);
            return new ResponseEntity<>(findByClientAppoinmentHandler.execute(clientCommand), OK);
        }
        return new ResponseEntity<>(findAllAppointmentHandler.execute(), OK);
    }
}
