package space.bum.spring_boot.repo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import space.bum.spring_boot.persist.Person;

@SpringBootTest
class PersonRepoTest {

  @Autowired
  private Session session;

  @Test
  @Transactional
  void whenTryPersistEvictedEntity_ifPersisExcepOccurs_ThenOk() {
    Person person = new Person();
    person.setName("John");
    session.persist(person);
    session.evict(person);
    assertThrows(PersistenceException.class, () -> session.persist(person));
  }
}
