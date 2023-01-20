package id.ac.ui.cs.advprog.tutorial5.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Article")
@Setter
@Getter
@NoArgsConstructor

public class Article {

    @JsonBackReference
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Editor editor;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false)
    private int id;

    private int totalReader;

    @Column(name = "title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="created_date",updatable = false)
    @CreationTimestamp
    private Date createdDate;

    @Column(name="updated_date")
    @UpdateTimestamp
    private Date updatedDate;

    public Article(String title,String text,Set<Category> category) {
        this.title = title;
        this.text  = text;
        this.categories = category;
    }

    @ManyToMany(mappedBy = "articles",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<Category> categories;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article)) return false;
        Article category = (Article) o;

        return category.getId() == (this.getId());
    }


}
