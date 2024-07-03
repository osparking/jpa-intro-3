package space.bum.spring_boot.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class ArticleTest {

  @Autowired
  private EntityManager entityManager;

  @Test
  @Transactional
  void givenIdentityStrategy_whenCommitTransction_thenReturnPrimaryKey() {
    Article article = new Article();
    article.setName("범이비누 효능 연구");

    entityManager.persist(article);
    assertNotNull(article.getId());

    Long expectPrimaryKey = 1L;
    assertEquals(expectPrimaryKey, article.getId());
    article = new Article();
    article.setName("고객 리뷰 종합연구");
    
    entityManager.persist(article);
    assertNotNull(article.getId());
    
    expectPrimaryKey = 2L;
    assertEquals(expectPrimaryKey, article.getId());
  }
}
