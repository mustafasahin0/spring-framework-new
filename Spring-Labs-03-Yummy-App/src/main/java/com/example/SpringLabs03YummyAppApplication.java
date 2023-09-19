package com.example;

import com.example.service.RecipeService;
import org.apache.catalina.Context;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringLabs03YummyAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(SpringLabs03YummyAppApplication.class, args);
        RecipeService recipeService = container.getBean(RecipeService.class);
        System.out.println("recipeService.prepareRecipe() = " + recipeService.prepareRecipe());
    }

}
