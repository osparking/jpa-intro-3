package space.bum.spring_boot.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import space.bum.spring_boot.jpaQ.UserEntity;

@Data
@Repository
public class UserJpqlRepo {
  @Autowired
  private EntityManager entityManager;

  public UserEntity getUserByIdWithPlainQuery(Long id) {

    Query jpqlQuery = getEntityManager()
        .createQuery("SELECT u FROM UserEntity u WHERE u.id=:id");
    jpqlQuery.setParameter("id", id);
    return (UserEntity) jpqlQuery.getSingleResult();
  }

  public UserEntity getUserByIdWithTypedQuery(Long id) {
    TypedQuery<UserEntity> typedQuery = getEntityManager().createQuery(
        "SELECT u FROM UserEntity u WHERE u.id=:id", UserEntity.class);

    typedQuery.setParameter("id", id);
    return typedQuery.getSingleResult();
  }

  public UserEntity getUserByIdWithNamedQuery(Long id) {
    Query namedQuery = entityManager
        .createNamedQuery("UserEntity.findByUserId");
    namedQuery.setParameter("userId", id);
    return (UserEntity) namedQuery.getSingleResult();
  }

  public UserEntity getUserByIdWithNativeQuery(Long id) {
    Query nativeQuery = entityManager.createNativeQuery(
        "SELECT * FROM users WHERE id=:userId", UserEntity.class);
    nativeQuery.setParameter("userId", id);
    return (UserEntity) nativeQuery.getSingleResult();
  }

  public UserEntity getUserByIdWithCriteriaQuery(Long id) {
    CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder
        .createQuery(UserEntity.class);
    Root<UserEntity> userRoot = criteriaQuery.from(UserEntity.class);
    UserEntity queryResult = getEntityManager()
        .createQuery(criteriaQuery.select(userRoot)
            .where(criteriaBuilder.equal(userRoot.get("id"), id)))
        .getSingleResult();
    return queryResult;
  }
}
