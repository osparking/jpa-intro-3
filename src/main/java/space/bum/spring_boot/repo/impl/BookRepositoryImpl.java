package space.bum.spring_boot.repo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;
import space.bum.spring_boot.criteria.Book;
import space.bum.spring_boot.repo.BookCustomRepo;

@Repository
@NoArgsConstructor
public class BookRepositoryImpl implements BookCustomRepo {
  @Autowired
  EntityManager em;

  @Override
  public List<Book> findBooksByAuthorNameAndTitle(String authorName,
      String title) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Book> cq = cb.createQuery(Book.class);

    Root<Book> book = cq.from(Book.class);
    List<Predicate> predicates = new ArrayList<>();

    if (authorName != null) {
      predicates.add(cb.equal(book.get("author"), authorName));
    }
    if (title != null) {
      predicates.add(cb.like(book.get("title"), "%" + title + "%"));
    }
    cq.where(predicates.toArray(new Predicate[0]));

    return em.createQuery(cq).getResultList();
  }
}
