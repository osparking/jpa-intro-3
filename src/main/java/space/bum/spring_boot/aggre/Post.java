package space.bum.spring_boot.aggre;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Post {
    @Id
    private Integer id;
    private String title;
    private String content;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
