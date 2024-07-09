package space.bum.spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import space.bum.spring_boot.criteria.Book;

public interface BookRepository
    extends JpaRepository<Book, Long>, BookCustomRepo {
}
