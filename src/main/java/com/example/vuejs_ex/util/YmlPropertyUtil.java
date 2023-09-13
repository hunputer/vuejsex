package com.example.vuejs_ex.util;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.*;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class YmlPropertyUtil {

    private final Environment environment;

    public String getProperty(String propertyName){
        AbstractEnvironment abstractEnvironment = new AbstractEnvironment(){};
        return abstractEnvironment.getProperty(propertyName);
    }

}
