package space.bum.spring_boot.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class AdminTest {

  @Autowired
  private EntityManager entityManager;

  @Test
  @Transactional
  void givenAutoStrategy_whenCommitTransction_thenReturnPrimaryKey() {
    var bum = new Admin();
    bum.setName("범이");

    entityManager.persist(bum);
    assertNotNull(bum.getId());

    Long expectPrimaryKey = 1L;
    assertEquals(expectPrimaryKey, bum.getId());
  }
}
