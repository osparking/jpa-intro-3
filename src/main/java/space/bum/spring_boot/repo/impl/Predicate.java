package space.bum.spring_boot.repo.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import space.bum.spring_boot.criteria.Book;

public class Predicate {

  public static Specification<Book> hasAuthor(String author) {
    return (book, cq, cb) -> cb.equal(book.get("author"), author);
  }

  public static Specification<Book> titleContains(String title) {
    return (book, cq, cb) -> cb.like(book.get("title"), "%" + title + "%");
  }
}
