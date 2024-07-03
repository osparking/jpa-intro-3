package space.bum.spring_boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "soap_admin")
@Data
public class Admin {
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Column(name = "admin_name")
  private String name;

}
