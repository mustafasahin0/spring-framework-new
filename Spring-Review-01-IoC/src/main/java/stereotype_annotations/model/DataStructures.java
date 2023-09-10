package stereotype_annotations.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataStructures {

    private final ExtraHours extraHours;

    public void getTotalHours() {
        System.out.println("DataStructure total hours: " + (40 + extraHours.getTotalHours()));
    }
}
