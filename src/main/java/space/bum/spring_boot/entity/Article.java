package space.bum.spring_boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "article")
@Data
public class Article {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE, generator = "article_gen")
  @SequenceGenerator(
      name = "article_gen", sequenceName = "article_seq", allocationSize = 1)
  private Long id;

  @Column(name = "article_name")
  private String name;
}