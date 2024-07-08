package space.bum.spring_boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import space.bum.spring_boot.criteria.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

  public default List<Item> findItemByColorAndGrade(
      EntityManager entityManager) {
    
    var criteriaBuilder = entityManager.getCriteriaBuilder();
    var criteriaQuery = criteriaBuilder.createQuery(Item.class);
    var itemRoot = criteriaQuery.from(Item.class);
    
    return null;
  }
}
