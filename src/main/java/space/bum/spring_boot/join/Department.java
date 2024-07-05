package space.bum.spring_boot.join;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  /**
   * 한 과(부서)에 여러 직원이 속할 수 있다.
   */
  @OneToMany(mappedBy = "department")
  private List<Employee> employees;
}
