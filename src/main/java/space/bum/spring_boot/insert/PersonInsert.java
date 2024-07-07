package space.bum.spring_boot.insert;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInsert {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
}