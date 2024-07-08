package space.bum.spring_boot.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import space.bum.spring_boot.aggre.Comment;
import space.bum.spring_boot.aggre.Post;

@SpringBootTest
class CommentRepoTest {
  @Autowired
  private PostRepo postRepo;
  @Autowired
  private CommentRepo commentRepo;
  
  @BeforeEach
  void setUp() throws Exception {
    var post = new Post();
    post.setId(1);
    post.setTitle("날씨 공지");
    post.setContent("밤새 폭우가 ...");
    postRepo.save(post);
    
    var comment = new Comment();
    comment.setId(1);
    comment.setPost(post);
    comment.setYear_written(2022);
    commentRepo.save(comment);
    
    comment = new Comment();
    comment.setId(2);
    comment.setPost(post);
    comment.setYear_written(2022);
    commentRepo.save(comment);
    
    comment = new Comment();
    comment.setId(3);
    comment.setPost(post);
    comment.setYear_written(2024);
    commentRepo.save(comment);
  }

  @Test
  void whenSelectHasConstructorCall_thenResultReturnsListOfObject() {
    var result = commentRepo.countTotalCommentsByYearClass();
    assertEquals(2, result.size());
  }
  
  @Test
  void whenSelectHasInterfaceMatchingAlias_thenResultsListOfInterface() {
    var result = commentRepo.countTotalCommentsByYearInterface();
    assertEquals(2, result.size());
  }

}
