package space.bum.spring_boot.join;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@SpringBootTest
@EnableTransactionManagement
class JoinTest {
  @Autowired
  private EntityManager entityManager;
//  private Department theDept = new Department(1L, "로봇청소기설계과", null);

//  @BeforeEach
//  @Transactional
//  void setUp() throws Exception {
//    entityManager
//        .createNativeQuery("INSERT INTO department " +
//            " (id, name) VALUES (?,?)", Department.class)
//        .setParameter(1, 1L)
//        .setParameter(2, "제품설계과")
//        .executeUpdate();
//
//    entityManager
//        .createNativeQuery("INSERT INTO employee " +
//            " (id, name, deparement) VALUES (?,?,?)")
//        .setParameter(1, 101L)
//        .setParameter(2, "홍길동")
//        .setParameter(3, theDept)
//        .executeUpdate();
//  }

  @Test
  public void whenSingleValuedAssociation_thenImplicitInnerJoin() {
    TypedQuery<Department> query = entityManager.createQuery(
        "SELECT e.department FROM Employee e", Department.class);
    List<Department> resultList = query.getResultList();
    assertEquals(0, resultList.size());
  }

}
