package space.bum.spring_boot.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class UserTest {

  @Autowired
  private EntityManager entityManager;

  @Test
  @Transactional
  void givenIdentityStrategy_whenCommitTransction_thenReturnPrimaryKey() {
    User user = new User();
    user.setName("범비단골");

    entityManager.persist(user);
    assertNotNull(user.getId());

    Long expectPrimaryKey = 1L;
    assertEquals(expectPrimaryKey, user.getId());
  }
}
