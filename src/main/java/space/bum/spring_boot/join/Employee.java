package space.bum.spring_boot.join;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity 
@Data
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private int age;

  @ManyToOne
  private Department department;

  /**
   * 한 직원은 전화번호를 여러개 가질 수 있다.
   */
  @OneToMany(mappedBy = "employee")
  private List<Phone> phones;
}
