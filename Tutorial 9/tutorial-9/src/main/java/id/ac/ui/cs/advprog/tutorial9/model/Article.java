package id.ac.ui.cs.advprog.tutorial9.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

// DO NOT TOUCH
@Entity
@Table(name = "article")
@Data
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "judul")
    private String judul;

    @Column(name = "isi", columnDefinition = "TEXT")
    private String isi;

    @Column(name="created_at")
    @JsonIgnore
    private Date createdAt;

    @Transient
    @JsonProperty("createdAt")
    private String createdAtView;
    
    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Article(String _judul, String _isi, Category cat, Date _createdAt) {
        judul = _judul;
        isi = _isi;
        category = cat;
        createdAt = _createdAt;
    }
}
