package com.ceiba.citas_medicas.application.config;

import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class BeanConfigTest {

    @Test
    void getCreateAppointmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertThat(beanConfig.getCreateAppointmentService(appointmentPersistence)).isNotNull();
    }

    @Test
    void getFindAllAppointmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertThat(beanConfig.getFindAllAppointmentService(appointmentPersistence)).isNotNull();
    }

    @Test
    void getFindAppointmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertThat(beanConfig.getFindAppointmentService(appointmentPersistence)).isNotNull();
    }

    @Test
    void getDeleteAppointmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertThat(beanConfig.getDeleteAppointmentService(appointmentPersistence)).isNotNull();
    }

    @Test
    void getFindByClientAppoinmentService() {
        // arrange
        var beanConfig = new BeanConfig();
        var appointmentPersistence = mock(AppointmentPersistence.class);

        // act - assert
        assertThat(beanConfig.getFindByClientAppoinmentService(appointmentPersistence)).isNotNull();
    }

    @Test
    void getCreateClientService() {
        // arrange
        var beanConfig = new BeanConfig();
        var clientPersistence = mock(ClientPersistence.class);

        // act - assert
        assertThat(beanConfig.getCreateClientService(clientPersistence)).isNotNull();
    }

    @Test
    void getDeleteClientService() {
        // arrange
        var beanConfig = new BeanConfig();
        var clientPersistence = mock(ClientPersistence.class);

        // act - assert
        assertThat(beanConfig.getDeleteClientService(clientPersistence)).isNotNull();
    }

    @Test
    void getFindAllClientService() {
        // arrange
        var beanConfig = new BeanConfig();
        var clientPersistence = mock(ClientPersistence.class);

        // act - assert
        assertThat(beanConfig.getFindAllClientService(clientPersistence)).isNotNull();
    }

    @Test
    void getFindClientService() {
        // arrange
        var beanConfig = new BeanConfig();
        var clientPersistence = mock(ClientPersistence.class);

        // act - assert
        assertThat(beanConfig.getFindClientService(clientPersistence)).isNotNull();
    }
}