package space.bum.spring_boot.join;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Phone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String number;

  @ManyToOne
  private Employee employee;
}
