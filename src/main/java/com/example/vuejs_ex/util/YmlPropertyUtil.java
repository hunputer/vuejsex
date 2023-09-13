package com.example.vuejs_ex.util;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
public class YmlPropertyUtil {

    private final Environment environment;

    public String getProperty(String propertyName){
        return environment.getProperty(propertyName);
    }

}
