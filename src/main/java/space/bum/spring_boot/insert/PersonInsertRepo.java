package space.bum.spring_boot.insert;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PersonInsertRepo {

  @PersistenceContext
  private EntityManager entityManager;
}
