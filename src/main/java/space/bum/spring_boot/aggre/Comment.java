package space.bum.spring_boot.aggre;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
  @Id
  private Integer id;
  private Integer year_written;
  private boolean approved;
  private String content;
  @ManyToOne
  private Post post;
}