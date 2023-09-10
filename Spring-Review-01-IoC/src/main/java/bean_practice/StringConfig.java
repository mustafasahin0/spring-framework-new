package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StringConfig {

    @Bean("getHelloName")
    public String getHello() {
        return "Welcome to CydeoApp";
    }

    @Bean
    public String getSpring() {
        return "Spring Core practice";
    }
}
