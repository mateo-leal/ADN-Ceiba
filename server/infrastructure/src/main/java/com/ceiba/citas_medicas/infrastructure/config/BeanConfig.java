package com.ceiba.citas_medicas.infrastructure.config;

import com.ceiba.citas_medicas.application.service.adapter.CitaServiceAdapter;
import com.ceiba.citas_medicas.application.service.api.CitaService;
import com.ceiba.citas_medicas.domain.persistence.CitaPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CitaService getCitaService(CitaPersistence persistence) {
        return new CitaServiceAdapter(persistence);
    }
}
