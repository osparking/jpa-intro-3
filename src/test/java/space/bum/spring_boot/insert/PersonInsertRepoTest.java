package space.bum.spring_boot.insert;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class PersonInsertRepoTest {
  @Autowired
  PersonInsertRepo personInsertRepo;

  @Test
  public void givenPersonEntity_whenInsertedTwice_thenExceptionIsThrown() {
    PersonInsert person = new PersonInsert(1L, "firstname", "lastname");

    assertThrows(DataIntegrityViolationException.class, () -> {
      personInsertRepo.insertWithQuery(person);
      personInsertRepo.insertWithQuery(person);
    });
  }

  @Test
  public void givenPersonEntity_whenInsertedTwice_thenExceptionExpected() {
    PersonInsert person = new PersonInsert(1L, "firstname", "lastname");
    assertThrows(DataIntegrityViolationException.class, () -> {
      personInsertRepo.insertWithEntityManager(person);
      personInsertRepo.insertWithEntityManager(person);
    });
  }
}
