package space.bum.spring_boot.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AccountId implements Serializable {

  private static final long serialVersionUID = -6817617586982809977L;
  private String accountNumber;
  private String accountType;
}
