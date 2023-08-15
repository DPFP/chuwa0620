package com.example.demo.modelMapper;

import com.example.demo.model.Customer;
import com.example.demo.payload.CustomerDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelMapperConfig {
    @Bean
    @Scope("singleton")
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);


        modelMapper.validate();

        return modelMapper;
    }
    private void customerToCustomerDto(ModelMapper modelMapper) {
        modelMapper.createTypeMap(Customer.class, CustomerDto.class)
                .addMapping(Customer::getId, CustomerDto::setId)
                .addMapping(Customer::getFirstname, CustomerDto::setFirstname)
                .addMapping(Customer::getLastname, CustomerDto::setLastname)
                .addMapping(Customer:: getEmail, CustomerDto::setEmail);
    }


}
