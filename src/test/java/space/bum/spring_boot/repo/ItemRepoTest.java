package space.bum.spring_boot.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import space.bum.spring_boot.criteria.Item;

@SpringBootTest
class ItemRepoTest {
  @Autowired
  private ItemRepo itemRepo;
  
  @Autowired
  EntityManager entityManager;

  @BeforeEach
  /**
   * 항목을 색상, 등급별로 총 6개 정도 저장한다.
   * @throws Exception
   */
  void setUp() throws Exception {
    String[] colors = {"red", "blue", "green"};
    String[] grades = {"A", "B", "C"};
    int idx = 1;
    
    for (String color : colors) {
      for (String grade : grades) {
        itemRepo.save(new Item((long)idx, color, grade, "항목" + idx));
        idx++;
      }
    }
  }

  @Test
  void findItemsWhenTableEmpty_thenReturnedListSizeIs_4_thenOk() {
    var result = itemRepo.findItemByColorAndGrade(entityManager);
    assertEquals(4, result.size());
  }
}
