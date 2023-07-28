package com.example.redbook.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CommonConfig {

    //当需要把第三方lib放入到IOC容器时候，则会用@Bean
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
