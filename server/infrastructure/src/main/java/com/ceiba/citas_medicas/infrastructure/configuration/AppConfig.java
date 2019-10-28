package com.ceiba.citas_medicas.infrastructure.configuration;

import com.ceiba.citas_medicas.domain.service.CrearCitaService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ceiba.citas_medicas" })
public class AppConfig {

    @Bean
    public CrearCitaService crearCitaService() {
        return new CrearCitaService()
    }
}
