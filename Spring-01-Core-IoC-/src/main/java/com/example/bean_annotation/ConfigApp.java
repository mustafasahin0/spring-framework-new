package com.example.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor() {
        return new FullTimeMentor();
    }

    @Bean
    PartTimeMentor partTimeMentor() {
        return new PartTimeMentor();
    }

    @Bean(name = "abc")
    PartTimeMentor partTimeMentor2() {
        return new PartTimeMentor();
    }

}
