package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FullTimeEmployee getFullTimeEmployee() {
        return new FullTimeEmployee();
    }

    @Bean
    public PartTimeEmployee getPartTimeEmployee() {
        return new PartTimeEmployee();
    }
}
