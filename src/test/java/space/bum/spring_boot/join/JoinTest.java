package space.bum.spring_boot.join;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@SpringBootTest
@EnableTransactionManagement
class JoinTest {
  @PersistenceContext
  private EntityManager entityManager;
  
  @Autowired
  private JoinRepository joinRepository;

  @BeforeEach
  @Transactional
  void setUp() throws Exception {
    Phone phone = new Phone();
    phone.setNumber("010-1111-2222");
    joinRepository.insertWithEntityManager(phone);
    
    Department department = new Department();
    department.setName("로봇설계과");
    joinRepository.insertWithEntityManager(department);
    
    Employee employee = new Employee();
    employee.setName("홍길동");
    employee.setAge(35);
    employee.setDepartment(department);
    List<Phone> phones = new ArrayList<>();
    phones.add(phone);
    employee.setPhones(phones);
    joinRepository.insertWithEntityManager(employee);
  }

  @Test
  public void whenSingleValuedAssociation_thenImplicitInnerJoin() {
    TypedQuery<Department> query = entityManager.createQuery(
        "SELECT e.department FROM Employee e", Department.class);
    List<Department> resultList = query.getResultList();
    assertEquals(1, resultList.size());
  }

}
