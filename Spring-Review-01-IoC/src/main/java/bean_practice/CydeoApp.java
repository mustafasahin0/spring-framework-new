package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {

        // How to create a Spring Container?
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class, StringConfig.class);

        FullTimeEmployee fullTimeEmployee = container.getBean(FullTimeEmployee.class);
        fullTimeEmployee.createAccount();
        PartTimeEmployee partTimeEmployee = container.getBean(PartTimeEmployee.class);
        partTimeEmployee.createAccount();

        String str1 = container.getBean("getHelloName",String.class);
        System.out.println(str1);
        String str2 = container.getBean("getSpring",String.class);
        System.out.println(str2);
    }
}
