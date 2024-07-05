package space.bum.spring_boot.join;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@SpringBootTest
@EnableTransactionManagement
class JoinTest {
  @PersistenceContext
  private EntityManager entityManager;

  @Test
  public void whenSingleValuedAssociation_thenImplicitInnerJoin() {
    TypedQuery<Department> query = entityManager.createQuery(
        "SELECT e.department FROM Employee e", Department.class);
    List<Department> resultList = query.getResultList();
    assertEquals(1, resultList.size());
  }

}
