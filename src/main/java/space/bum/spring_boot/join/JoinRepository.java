package space.bum.spring_boot.join;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class JoinRepository {

  @PersistenceContext
  private EntityManager entityManager;
  
  @Transactional
  public void insertWithEntityManager(Department department) {
      this.entityManager.persist(department);
  }
  
  @Transactional
  public void insertWithEntityManager(Employee employee) {
    this.entityManager.persist(employee);
  }
  
  @Transactional
  public void insertWithEntityManager(Phone phone) {
    this.entityManager.persist(phone);
  }
}
