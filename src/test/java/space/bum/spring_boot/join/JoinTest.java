package space.bum.spring_boot.join;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@EnableTransactionManagement
@Slf4j
class JoinTest {
  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private JoinRepository joinRepository;

  @BeforeEach
  @Transactional
  void setUp() throws Exception {
    Department department1 = new Department();
    department1.setName("판매홍보과");
    joinRepository.insertWithEntityManager(department1);

    Department department = new Department();
    department.setName("로봇설계과");
    joinRepository.insertWithEntityManager(department);

    Employee employee = new Employee();
    employee.setName("홍길동");
    employee.setAge(35);
    employee.setDepartment(department);
    joinRepository.insertWithEntityManager(employee);

    Phone phone = new Phone();
    phone.setNumber("010-1111-2222");
    phone.setEmployee(employee);
    joinRepository.insertWithEntityManager(phone);

    Employee employee2 = new Employee();
    employee2.setName("임꺽정");
    employee2.setAge(41);
    employee2.setDepartment(department);
    joinRepository.insertWithEntityManager(employee2);

    Phone phone2 = new Phone();
    phone2.setNumber("010-3333-4444");
    phone2.setEmployee(employee2);
    joinRepository.insertWithEntityManager(phone2);

    Phone phone3 = new Phone();
    phone3.setNumber("010-5555-6666");
    phone3.setEmployee(employee2);
    joinRepository.insertWithEntityManager(phone3);
  }

  @Test
  public void whenSingleValuedAssociation_thenImplicitInnerJoin() {
    TypedQuery<Department> query = entityManager.createQuery(
        "SELECT e.department FROM Employee e", Department.class);
    List<Department> resultList = query.getResultList();
    assertEquals(1, resultList.size());
  }

  @Test
  public void whenJoinKeywordIsUsed_thenCreatesExplicitInnerJoin() {
    TypedQuery<Department> query = entityManager.createQuery(
        "SELECT d FROM Employee e inner JOIN e.department d", Department.class);
    List<Department> resultList = query.getResultList();
    assertEquals(1, resultList.size());
  }

  @Test
  public void whenCollecValueAssocSpecifiedInSelect_ThenReturnsCollections() {
    TypedQuery<Phone> query = entityManager.createQuery(
        "SELECT e.phones FROM Employee e", Phone.class);
    List<Phone> resultList = query.getResultList();
    assertEquals(2, resultList.size());
  }

  @Test
  public void whenCollectionValuedAssociationIsJoined_ThenCanSelect() {
    TypedQuery<Phone> query = entityManager.createQuery(
        "SELECT ph FROM Employee e JOIN e.phones ph WHERE ph.number LIKE '%11%'",
        Phone.class);
    List<Phone> resultList = query.getResultList();
    assertEquals(1, resultList.size());
  }

  @Test
  public void whenLeftSpecified_thenCreatesOuterJoinAndIncludesNonMatched() {
    TypedQuery<Department> query = entityManager.createQuery(
        "SELECT DISTINCT d FROM Department d LEFT JOIN d.employees e",
        Department.class);
    List<Department> resultList = query.getResultList();
    assertEquals(2, resultList.size());
  }

  @Test
  public void whenEntitiesListedInFromAndMatchedInWhere_ThenJoins() {
    TypedQuery<Department> query = entityManager.createQuery(
        "SELECT d FROM Employee e, Department d WHERE e.department = d",
        Department.class);
    List<Department> resultList = query.getResultList();
    assertEquals(1, resultList.size());
  }

  @Test
  public void whenEntitiesAreListedInFrom_ThenCreatesCartesianProduct2() {
    TypedQuery<Long> query = entityManager.createQuery(
        "SELECT count(*)d FROM Employee e, Department d", Long.class);
    Long resultList = query.getSingleResult();
    assertEquals(4L, resultList);
  }

  @Test
  public void whenEntitiesAreListedInFrom_ThenCreatesCartesianProduct() {
    TypedQuery<Employee> query = entityManager.createQuery(
        "SELECT e FROM Employee e, Department d", Employee.class);
    List<Employee> resultList = query.getResultList();
    assertEquals(2, resultList.size());
  }

  @Test
  public void whenMultipleEntitiesListedWithJoin_ThenCreatesMultipleJoins() {
    TypedQuery<Phone> query = entityManager.createQuery(
        "SELECT ph FROM Employee e JOIN e.department d "
            + "JOIN e.phones ph WHERE d.name IS NOT NULL",
        Phone.class);
    List<Phone> resultList = query.getResultList();
    assertEquals(3, resultList.size());
  }

  @Test
  public void whenFetchKeywordIsSpecified_ThenCreatesFetchJoin() {
    TypedQuery<Department> query = entityManager.createQuery(
        "SELECT d FROM Department d JOIN d.employees", Department.class);
    List<Department> resultList = query.getResultList();
    assertEquals(1, resultList.size());
  }
}
