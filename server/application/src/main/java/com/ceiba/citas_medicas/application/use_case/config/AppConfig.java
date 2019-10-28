package com.ceiba.citas_medicas.application.use_case.config;

import com.ceiba.citas_medicas.application.use_case.adapter.CrearCitaUseCaseAdapter;
import com.ceiba.citas_medicas.application.use_case.api.CrearCitaUseCase;
import com.ceiba.citas_medicas.domain.persistence.CitaPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CrearCitaUseCase getCrearCitaUseCase() {
        return new CrearCitaUseCaseAdapter(citaPersistence);
    }
}
