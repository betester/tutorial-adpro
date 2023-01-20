package id.ac.ui.cs.advprog.tutorial9.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

// DO NOT TOUCH
@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private List<Article> articles;

    @Transient
    private String mostRecentArticle;

    @Transient
    private int numArticles;

    public Category(String name){
        this.name = name;
    }

}
