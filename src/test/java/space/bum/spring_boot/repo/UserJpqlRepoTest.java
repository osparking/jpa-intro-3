package space.bum.spring_boot.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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

  private static Long id = 1L;
  
  @BeforeEach
  private void createOneUser() {
    userRepository.save(new UserEntity(id, "이"));
  }

  @Test
  void testGetUserByIdWithPlainQuery() {
    userRepository.save(new UserEntity(id, "김"));

    var userRead = userJpqlRepo.getUserByIdWithPlainQuery(id);
    assertEquals(id, userRead.getId());
  }

  @Test
  void testGetUserByIdWithTypedQuery() {
    userRepository.save(new UserEntity(id, "이"));
    
    var userRead = userJpqlRepo.getUserByIdWithTypedQuery(id);
    assertEquals(id, userRead.getId());
  }
  
  @Test
  void testGetUserByIdWithNamedQuery() {
    userRepository.save(new UserEntity(id, "이"));
    
    var userRead = userJpqlRepo.getUserByIdWithNamedQuery(id);
    assertEquals(id, userRead.getId());
  }
  
  @Test
  void testGetUserByIdWithNativeQuery() {
    var userRead = userJpqlRepo.getUserByIdWithNativeQuery(id);
    assertEquals(id, userRead.getId());
  }
  
  @Test
  void testGetUserByIdWithCriteriaQuery() {
    var userRead = userJpqlRepo.getUserByIdWithCriteriaQuery(id);
    assertEquals(id, userRead.getId());
  }

}
