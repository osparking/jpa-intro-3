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
}
