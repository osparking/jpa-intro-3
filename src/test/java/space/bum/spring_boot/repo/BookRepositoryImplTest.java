package space.bum.spring_boot.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import space.bum.spring_boot.controller.BookController;

@SpringBootTest
class BookRepositoryImplTest {

  @Autowired
  private BookController bookController;
  
  @BeforeEach
  /**
   * 몇 가지 서적을 다양한 저자와 제목을 할당하여 생성한다.
   * 
   * @throws Exception
   */
  void setUp() throws Exception {
    bookController.saveBook(1L, "조정래", "태백산맥");
    bookController.saveBook(2L, "조정래", "아리랑");
  }

  @Test
  /**
   * 조정래의 태백산맥을 검색하여 1건이 찾아졌으면 성공이다.
   * 
   */
  void 만약_조정래의_태백산맥을_검색하여_1건이_찾아졌으면_성공() {
    var list = bookController.findBooksByAuthorTitle("조정래", "아리랑");
    assertEquals(1, list.size());
  }

  @Test
  /**
   * 조정래의 모든 저서를 검색하여 2건이 찾아졌으면 성공이다.
   */
  void 만약_조정래의_모든_저서_검색하여_2건이_찾아졌으면_성공() {
    var list = bookController.findBooksByAuthor("조정래");
    assertEquals(2, list.size());
  }

}
