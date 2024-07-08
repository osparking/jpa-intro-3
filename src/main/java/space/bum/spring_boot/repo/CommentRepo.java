package space.bum.spring_boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import space.bum.spring_boot.aggre.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
  @Query("SELECT new space.bum.spring_boot.repo.CommentCount("
      + "c.year, COUNT(c.year)) FROM Comment AS c "
      + "GROUP BY c.year ORDER BY c.year DESC")
    List<CommentCount> countTotalCommentsByYearClass();
}
