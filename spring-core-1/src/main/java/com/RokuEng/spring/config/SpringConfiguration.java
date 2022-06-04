package com.RokuEng.spring.config;

import com.RokuEng.spring.domain.pet.Cat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "com.RokuEng.spring")
@PropertySource("classpath:application.properties")
public class SpringConfiguration {

//    @Value("${cat.name}")
//    private String name;
//
//    @Bean
//    public Cat cat() {
//        return new Cat(name);
//    }
//
//    @Bean
//    public String catName() {
//        return name;
//    }
}
