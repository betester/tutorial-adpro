package id.ac.ui.cs.advprog.tutorial5.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "editor")
@Data
@NoArgsConstructor
public class Editor {
    // many to one dengan article
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="article_id")
    private Set<Article> articles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @CreatedDate
    @Column(name = "registered_at")
    private Date registeredAt;

    @Column(name = "written_articles")
    @Formula("select count(*) from article where article.editor_id = id")
    private int writtenArticles;


    public Editor(String name, String email, int writtenArticles){
        this.name = name;
        this.email = email;
        this.writtenArticles = writtenArticles;
    }
}
