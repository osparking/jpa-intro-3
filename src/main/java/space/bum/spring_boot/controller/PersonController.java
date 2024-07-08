package space.bum.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import space.bum.spring_boot.persist.Person;
import space.bum.spring_boot.repo.PersonRepo;

@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonRepo personRepo;

  @GetMapping("/create")
  public Long createPerson() {
    Person person = new Person();
    
    person.setName("줄리안 어산지");
    personRepo.createPerson(person);
    
    return person.getId();
  }
  
  @GetMapping("/merge")
  public Person mergePerson() {
    Person person = new Person(); 
    
    person.setName("김가놈");
    
    Person merged = (Person) personRepo.mergePerson(person);
    
    return merged;
  }
}
