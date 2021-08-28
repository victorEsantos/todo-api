package com.victor.todo.config;

import com.victor.todo.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "test")
public class TestConfig {
    @Autowired
    private DBService dbservice;


    @Bean
    public boolean instancia(){
        this.dbservice.instantiateDataBase();
        return true;
    }
}
