package com.hasindu.redissample.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author hasindu_d
 */
@org.springframework.context.annotation.Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
