package space.bum.spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import space.bum.spring_boot.aggre.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
}
