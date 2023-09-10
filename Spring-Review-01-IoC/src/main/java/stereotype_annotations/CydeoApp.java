package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.AppConfig;
import stereotype_annotations.model.DataStructures;
import stereotype_annotations.model.MicroService;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        DataStructures dataStructures = container.getBean(DataStructures.class);
        dataStructures.getTotalHours();
        MicroService microService = container.getBean(MicroService.class);
        microService.getTotalHours();
    }

}
