package id.ac.ui.cs.advprog.tutorial5.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Category")
@Setter
@Getter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "category_name",unique = true)
    private String name;

    @Column(name = "num_articles")
    @Formula("select count(*) from categories where id = categories.category_id")
    private int numArticles;

    private int totalReaderBasedOnArticle;

    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private Set<Category> categories;

    @JsonBackReference
    @ManyToOne
    private Category category;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "categories",
            joinColumns = @JoinColumn(name = "category_id",nullable = false,updatable = false),
            inverseJoinColumns = @JoinColumn(name = "article_id",nullable = false,updatable = false
            )
    )
    @JsonIgnore
    Set<Article> articles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;

        return category.getName().equals(this.getName());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", numArticles=" + numArticles +
                ", categories=" + categories +
                "}";
    }

    public Category(String name, int numArticles) {
        this.name = name;
        this.numArticles = numArticles;
    }

}
