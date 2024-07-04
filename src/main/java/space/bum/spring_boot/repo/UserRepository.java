package space.bum.spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import space.bum.spring_boot.jpaQ.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
