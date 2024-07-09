package space.bum.spring_boot.criteria;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
  @Id
  Long id;
  String title;
  String author;
}
