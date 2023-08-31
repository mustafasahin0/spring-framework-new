package com.example.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        FullTimeMentor fullTimeMentor = container.getBean(FullTimeMentor.class);
        fullTimeMentor.createAccount();

        ConfigAny configAny = container.getBean(ConfigAny.class);
        System.out.println(configAny.str());

        PartTimeMentor partTimeMentor = container.getBean("abc", PartTimeMentor.class);
        partTimeMentor.createAccount();
    }
}
