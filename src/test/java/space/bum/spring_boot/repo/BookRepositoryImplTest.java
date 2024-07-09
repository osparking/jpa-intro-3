package space.bum.spring_boot.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import space.bum.spring_boot.criteria.Book;

@SpringBootTest
class BookRepositoryImplTest {

  @Autowired
  private BookRepository bookRepository;
  
  @BeforeEach
  /**
   * 몇 가지 서적을 다양한 저자와 제목을 할당하여 생성한다.
   * @throws Exception
   */
  void setUp() throws Exception {
    var book = new Book();
    book.setId(1L);
    book.setAuthor("조정래");
    book.setTitle("태백산맥");
    bookRepository.save(book);
    
    book = new Book();
    book.setId(2L);
    book.setAuthor("조정래");
    book.setTitle("아리랑");
    bookRepository.save(book);
  }

  @Test
  /**
   * 조정래의 태백산맥을 검색하여 1건이 찾아졌으면 성공이다.
   */
  void 만약_조정래의_태백산맥을_검색하여_1건이_찾아졌으면_성공() {
    var list = bookRepository.findBooksByAuthorNameAndTitle("조정래", "산맥");
    assertEquals(1, list.size());
  }

}
