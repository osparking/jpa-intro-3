package space.bum.spring_boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import space.bum.spring_boot.criteria.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

  public default List<Item> findItemByColorAndGrade(
      EntityManager entityManager) {

    var criteriaBuilder = entityManager.getCriteriaBuilder();
    var criteriaQuery = criteriaBuilder.createQuery(Item.class);
    var itemRoot = criteriaQuery.from(Item.class);

    Predicate predicateForBlueColor = criteriaBuilder
        .equal(itemRoot.get("color"), "blue");
    Predicate predicateForRedColor = criteriaBuilder
        .equal(itemRoot.get("color"), "red");
    Predicate predicateForColor = criteriaBuilder.or(predicateForBlueColor,
        predicateForRedColor);

    return null;
  }
}
