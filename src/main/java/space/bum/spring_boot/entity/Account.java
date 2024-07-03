package space.bum.spring_boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(AccountId.class)
public class Account {
  @Id
  private String accountNumber;
  
  @Id
  private String accountType;

}
