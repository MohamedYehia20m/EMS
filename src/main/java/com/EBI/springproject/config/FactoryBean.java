package com.EBI.springproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBean {


    @Bean
    public ModelMapper getModelMapper() {

        return new ModelMapper();
    }
}
