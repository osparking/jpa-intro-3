package space.bum.spring_boot.repo;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import space.bum.spring_boot.persist.Person;

@Repository
public class PersonRepo {
  @Autowired
  private Session session;

  @Transactional
  public Person createPerson(Person person) {
    session.persist(person);   
    return person;
  }
}
