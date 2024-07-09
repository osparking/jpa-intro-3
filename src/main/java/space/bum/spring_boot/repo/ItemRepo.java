package space.bum.spring_boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import space.bum.spring_boot.criteria.Item;

@Repository
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

    Predicate predicateForGradeA = criteriaBuilder.equal(itemRoot.get("grade"),
        "A");
    Predicate predicateForGradeB = criteriaBuilder.equal(itemRoot.get("grade"),
        "B");
    Predicate predicateForGrade = criteriaBuilder.or(predicateForGradeA,
        predicateForGradeB);

    Predicate finalPredicate = criteriaBuilder.and(predicateForColor,
        predicateForGrade);

    criteriaQuery.where(finalPredicate);

    return entityManager.createQuery(criteriaQuery).getResultList();
  }

  public default List<Item> findItemOfSpecificColorAndGrade(
      EntityManager entityManager) {

    var criteriaBuilder = entityManager.getCriteriaBuilder();
    var criteriaQuery = criteriaBuilder.createQuery(Item.class);
    var itemRoot = criteriaQuery.from(Item.class);

    Predicate predicateForRedColor = criteriaBuilder
        .equal(itemRoot.get("color"), "red");
    Predicate predicateForGradeC = criteriaBuilder.equal(itemRoot.get("grade"),
        "C");  
    Predicate colorGradeComboPred_1 = criteriaBuilder.and(predicateForRedColor,
        predicateForGradeC);
    
    Predicate predicateForBlue = criteriaBuilder
        .equal(itemRoot.get("color"), "blue");
    Predicate predicateForGradeB = criteriaBuilder.equal(itemRoot.get("grade"),
        "B");  
    Predicate colorGradeComboPred_2 = criteriaBuilder.and(predicateForBlue,
        predicateForGradeB);

    Predicate finalPredicate = criteriaBuilder.or(colorGradeComboPred_1,
        colorGradeComboPred_2);

    criteriaQuery.where(finalPredicate);

    return entityManager.createQuery(criteriaQuery).getResultList();
  }
}
