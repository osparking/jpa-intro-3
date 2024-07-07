package space.bum.spring_boot.persist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {
  
  @Id
  @GeneratedValue
  private Long id;
  private String name;
}
