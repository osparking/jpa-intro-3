package space.bum.spring_boot.repo;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import space.bum.spring_boot.persist.Person;

@Slf4j
@Repository
public class PersonRepo {
  @Autowired
  private Session session;

  @Transactional
  public Person createPerson(Person person) {
    session.persist(person);
    return person;
  }

  @Transactional
  public Person mergePerson(Person person) {
    session.persist(person);
    session.flush();
    log.info("persist 후 : {}", person.getId());
    session.evict(person);
    person.setName("김선생님");
    person = session.merge(person);
    log.info("merge 후 : {}", person.getId());
    return person;
  }

  private static Person savedPerson = null;
  
  @Transactional
  public Person refreshPerson(Person person) throws InterruptedException {
    session.persist(person);
    session.flush();
    savedPerson = person;
    Thread.sleep(5000);
    session.refresh(person);
    return person;
  }

  @Transactional
  public Person changePerson() {
    savedPerson.setName("새선생님");
    session.merge(savedPerson);
    session.flush();    
    return savedPerson;
  }
}