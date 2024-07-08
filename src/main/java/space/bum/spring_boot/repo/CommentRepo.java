package space.bum.spring_boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import space.bum.spring_boot.aggre.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
  @Query("SELECT new space.bum.spring_boot.repo.CommentCount("
      + "c.year_written, COUNT(c.year_written)) FROM Comment AS c "
      + "GROUP BY c.year_written ORDER BY c.year_written DESC")
    List<CommentCount> countTotalCommentsByYearClass();
}
