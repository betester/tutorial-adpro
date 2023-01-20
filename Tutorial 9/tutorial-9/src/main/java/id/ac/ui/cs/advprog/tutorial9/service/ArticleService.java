package id.ac.ui.cs.advprog.tutorial9.service;

import java.util.List;

import id.ac.ui.cs.advprog.tutorial9.model.Article;
import id.ac.ui.cs.advprog.tutorial9.model.ArticleView;

public interface ArticleService {
    List<Article> getListArticle(int page, int limit);
    Article getArticleById(int id);
    List<ArticleView> getArticleViewByDate(String date, int page, int limit);

}
