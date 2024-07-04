package space.bum.spring_boot.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
}
