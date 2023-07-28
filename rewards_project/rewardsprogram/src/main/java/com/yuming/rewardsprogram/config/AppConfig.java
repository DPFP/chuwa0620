package com.yuming.rewardsprogram.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /**
     * 当需要把第三方lib放入到IOC容器时候，则会用@Bean
     * @return
     */
    // "modelmapper" -> new ModelMapper();
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
