package space.bum.spring_boot.repo;

import java.util.List;

import space.bum.spring_boot.criteria.Book;

public interface BookCustomRepo {
  List<Book> findBooksByAuthorNameAndTitle(String authorName, String title);
}
