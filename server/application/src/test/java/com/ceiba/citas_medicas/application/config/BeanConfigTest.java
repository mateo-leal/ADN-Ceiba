package com.ceiba.citas_medicas.application.config;

import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class BeanConfigTest {

    @Test
    void getCreateAppointmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertNotNull(beanConfig.getCreateAppointmentService(appointmentPersistence));
    }

    @Test
    void getFindAllAppointmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertNotNull(beanConfig.getFindAllAppointmentService(appointmentPersistence));
    }

    @Test
    void getFindAppointmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertNotNull(beanConfig.getFindAppointmentService(appointmentPersistence));
    }

    @Test
    void getDeleteAppointmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertNotNull(beanConfig.getDeleteAppointmentService(appointmentPersistence));
    }

    @Test
    void getFindByClientAppoinmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertNotNull(beanConfig.getFindByClientAppoinmentService(appointmentPersistence));
    }

    @Test
    void getCreateClientService() {
        // arrange
        var beanConfig = new BeanConfig();
        var clientPersistence = mock(ClientPersistence.class);

        // act - assert
        assertNotNull(beanConfig.getCreateClientService(clientPersistence));
    }

    @Test
    void getDeleteClientService() {
        // arrange
        var beanConfig = new BeanConfig();
        var clientPersistence = mock(ClientPersistence.class);

        // act - assert
        assertNotNull(beanConfig.getDeleteClientService(clientPersistence));
    }

    @Test
    void getFindAllClientService() {
        // arrange
        var beanConfig = new BeanConfig();
        var clientPersistence = mock(ClientPersistence.class);

        // act - assert
        assertNotNull(beanConfig.getFindAllClientService(clientPersistence));
    }

    @Test
    void getFindClientService() {
        // arrange
        var beanConfig = new BeanConfig();
        var clientPersistence = mock(ClientPersistence.class);

        // act - assert
        assertNotNull(beanConfig.getFindClientService(clientPersistence));
    }
}