package com.ceiba.citas_medicas.application.config;

import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import com.ceiba.citas_medicas.domain.service.appointment.*;
import com.ceiba.citas_medicas.domain.service.client.CreateClientService;
import com.ceiba.citas_medicas.domain.service.client.DeleteClientService;
import com.ceiba.citas_medicas.domain.service.client.FindAllClientService;
import com.ceiba.citas_medicas.domain.service.client.FindClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    //Services
    @Bean
    public CreateAppointmentService getCreateAppointmentService(AppointmentPersistence appointmentPersistence) {
        return new CreateAppointmentService(appointmentPersistence);
    }

    @Bean
    public FindAllAppointmentService getFindAllAppointmentService(AppointmentPersistence appointmentPersistence) {
        return new FindAllAppointmentService(appointmentPersistence);
    }

    @Bean
    public FindAppointmentService getFindAppointmentService(AppointmentPersistence appointmentPersistence) {
        return new FindAppointmentService(appointmentPersistence);
    }

    @Bean
    public DeleteAppointmentService getDeleteAppointmentService(AppointmentPersistence appointmentPersistence) {
        return new DeleteAppointmentService(appointmentPersistence);
    }

    @Bean
    public FindByClientAppointmentService getFindByClientAppoinmentService(AppointmentPersistence appointmentPersistence) {
        return new FindByClientAppointmentService(appointmentPersistence);
    }

    @Bean
    public CreateClientService getCreateClientService(ClientPersistence clientPersistence) {
        return new CreateClientService(clientPersistence);
    }

    @Bean
    public DeleteClientService getDeleteClientService(ClientPersistence clientPersistence) {
        return new DeleteClientService(clientPersistence);
    }

    @Bean
    public FindAllClientService getFindAllClientService(ClientPersistence clientPersistence) {
        return new FindAllClientService(clientPersistence);
    }

    @Bean
    public FindClientService getFindClientService(ClientPersistence clientPersistence) {
        return new FindClientService(clientPersistence);
    }
}
