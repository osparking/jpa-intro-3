package space.bum.spring_boot.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCount {
  private Integer year_written;
  private Long total;
}
