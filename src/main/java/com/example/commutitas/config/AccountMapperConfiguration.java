package com.example.commutitas.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class AccountMapperConfiguration {

    @Bean
    public ObjectMapper accountMapper() {
        ObjectMapper accountMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));

        accountMapper.registerModule(module);
        return accountMapper;
    }
}
