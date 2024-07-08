package space.bum.spring_boot.criteria;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {

    @Id
    private Long id;
    private String color;
    private String grade;
    private String name;
}
