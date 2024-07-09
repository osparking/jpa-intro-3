package space.bum.spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import static space.bum.spring_boot.repo.impl.Predicate.hasAuthor;
import static space.bum.spring_boot.repo.impl.Predicate.titleContains;

import space.bum.spring_boot.criteria.Book;
import space.bum.spring_boot.repo.BookRepository;

@RestController
public class BookController {

  @Autowired
  private BookRepository bookRepository;  
  /**
   * 서적 저장 메소드
   */
  public Book saveBook(Long id, String author, String title) {
    var book = new Book();
    book.setId(id);
    book.setAuthor(author);
    book.setTitle(title);
    return bookRepository.save(book);
  }
  
  /**
   * 서적 검색 메소드 제 1판
   */
  public List<Book> findBooksByAuthorTitle(String author, String title) {
    var list = bookRepository
        .findAll(hasAuthor(author).and(titleContains(title)));
    return list;
  }
  
  /**
   * 서적 검색 메소드 제 2판
   */
  public List<Book> findBooksByAuthor(String author) {
    var list = bookRepository.findAll(hasAuthor(author));
    return list;
  }

}
