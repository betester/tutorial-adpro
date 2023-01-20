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
@Table(name = "article_view", indexes = {
    @Index(name = "DateIndex", columnList = "date")
})
@Data
@NoArgsConstructor
public class ArticleView {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name="ip_address")
    private String ipAddress;

    @Column(name="date")
    @JsonIgnore
    private Date date;

    @Transient
    @JsonProperty("date")
    private String dateDisplay;

    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name="article_id")
    private Article article;

    public ArticleView(String _ipAddress, Date _date, Article _article) {
        ipAddress = _ipAddress;
        date = _date;
        article = _article;
    }
}
