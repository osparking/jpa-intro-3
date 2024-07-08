package space.bum.spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import space.bum.spring_boot.aggre.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
