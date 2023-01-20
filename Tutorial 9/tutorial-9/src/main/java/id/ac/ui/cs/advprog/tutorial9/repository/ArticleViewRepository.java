package id.ac.ui.cs.advprog.tutorial9.repository;

import id.ac.ui.cs.advprog.tutorial9.model.ArticleView;
import id.ac.ui.cs.advprog.tutorial9.model.Category;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleViewRepository extends JpaRepository<ArticleView, Integer> {

    @Query(value="SELECT * FROM article_view LEFT JOIN article ON article.id = article_id WHERE article_view.date BETWEEN ?1 AND ?2 ORDER BY date ASC LIMIT ?4 OFFSET ?3",
            nativeQuery=true)
    List<ArticleView> findByDate(Date start,
                                 Date end, 
                                 int offset, 
                                 int limit);
}
