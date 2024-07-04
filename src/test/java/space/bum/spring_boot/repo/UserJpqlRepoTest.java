package space.bum.spring_boot.repo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import space.bum.spring_boot.jpaQ.UserEntity;

@SpringBootTest
class UserJpqlRepoTest {
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private UserJpqlRepo userJpqlRepo;

  @Test
  void testGetUserByIdWithPlainQuery() {
    var id = 1L;
    userRepository.save(new UserEntity(id, "김"));
    
    var userRead =userJpqlRepo.getUserByIdWithPlainQuery(id);
    assertEquals(id, userRead.getId());
  }

}
