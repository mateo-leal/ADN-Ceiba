package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.infrastructure.repository.AppointmentRepository;
import com.ceiba.citas_medicas.infrastructure.repository.ClientRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.AppointmentEntity;
import com.ceiba.citas_medicas.infrastructure.repository.entity.ClientEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AppointmentSpringJpaAdapterTest {

    @Mock private AppointmentRepository repository;
    @Mock private ClientRepository clientRepository;

    private final double precio = 20000d;
    private final ClientEntity clientEntity = new ClientEntity(1L, "1234567890", "John Doe");
    private final LocalDateTime today = LocalDateTime.of(2019, Month.NOVEMBER, 13, 12, 0);
    private final AppointmentEntity appointmentEntity = new AppointmentEntity(1L, today, today.plusDays(1), precio, clientEntity);
    private final Client client = new Client(1L, "1234567890", "John Doe");
    private final Appointment appointment = new Appointment(today, today.plusDays(1), client);

    @Test
    void save() {
        // arrange
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository, clientRepository);
        doReturn(appointmentEntity).when(repository).save(any(AppointmentEntity.class));
        // act
        var response = appointmentSpringJpaAdapter.save(appointment);
        // assert
        assertThat(response).isNotNull();
    }

    @Test
    void delete() {
        // arrange
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository, clientRepository);
        // act
        appointmentSpringJpaAdapter.delete(appointment);
    }

    @Test
    void findAll() {
        // arrange
        doReturn(List.of(appointmentEntity)).when(repository).findAll();
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository, clientRepository);
        // act
        var response = appointmentSpringJpaAdapter.findAll();
        // assert
        assertThat(response).isNotEmpty();
    }

    @Test
    void find() {
        doReturn(Optional.of(appointmentEntity)).when(repository).findById(anyLong());
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository, clientRepository);
        // act
        var response = appointmentSpringJpaAdapter.find(1L);
        // assert
        assertThat(response).isPresent();
    }

    @Test
    void findByClient() {
        doReturn(Optional.of(clientEntity)).when(clientRepository).findByDocumentNumber(anyString());
        doReturn(List.of(appointmentEntity)).when(repository).findByClient(any(ClientEntity.class));
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository, clientRepository);
        // act
        var response = appointmentSpringJpaAdapter.findByClient(client);
        // assert
        assertThat(response).isNotEmpty();
    }
}