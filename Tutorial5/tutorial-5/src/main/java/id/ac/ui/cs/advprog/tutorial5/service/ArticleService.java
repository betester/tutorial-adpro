package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;

public interface ArticleService {
    Iterable<Article> getListArticle();

    Article createArticle(Article article);

    Article getArticleById(int id);

    Article updateArticle(int id, Article article);

    void deleteArticleById(int id);

    Article addCategory(int id, Category category);

    void removeCategory(int articleId, int categoryId);

}
