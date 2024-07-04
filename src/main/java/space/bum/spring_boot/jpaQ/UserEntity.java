package space.bum.spring_boot.jpaQ;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "UserEntity.findByUserId", 
            query = "SELECT u FROM UserEntity u WHERE u.id=:userId")
public class UserEntity {
  @Id
  private Long id;
  private String name;
}
