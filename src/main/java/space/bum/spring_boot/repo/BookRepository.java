package space.bum.spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import space.bum.spring_boot.criteria.Book;

public interface BookRepository
    extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
