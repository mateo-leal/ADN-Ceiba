package com.ceiba.citas_medicas.application.use_case.persona;

import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class CrearClientUseCaseTest {

    @Test
    public void execute() {
        // arrange
        var persistence = mock(ClientPersistence.class);
        var validation = mock(PersonaValidation.class);
        var useCase = new CrearPersonaUseCase(persistence, validation);
        //var persona = new Client();

        // act
        //var personaNew = useCase.execute(persona);

        // assert

    }
}