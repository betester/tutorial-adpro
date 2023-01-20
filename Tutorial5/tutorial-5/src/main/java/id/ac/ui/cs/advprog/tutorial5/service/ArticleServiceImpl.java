package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Article createArticle(Article article) {
        articleRepository.save(article);
        return article;
    }

    @Override
    public Article getArticleById(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public Iterable<Article> getListArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Article updateArticle(int id, Article article) {
        article.setId(id);
        articleRepository.save(article);
        return article;
    }

    @Override
    public void deleteArticleById(int id) {
        Article article = articleRepository.findById(id);
        if(article != null)
            articleRepository.delete(article);
    }

    @Override
    public Article addCategory(int id, Category category) {
        Category existedCategory = existingCategory(category);
        category = existedCategory == null ? category : existedCategory;

        Article article  = articleRepository.getById(id);

        if (article == null) {
            return null;
        }

        addArticleNumberOnCategory(category,article);
        return article;
    }

    public Category existingCategory(Category category) {
        return categoryRepository.findByName(category.getName());
    }

    public void addArticleNumberOnCategory(Category category,Article article) {
        if (category == null || article == null) {
            return;
        }
        else if (article.getCategories().contains(category)) {
            return;
        }
        else {
            article.getCategories().add(category);
            category.getArticles().add(article);
            categoryRepository.save(category);
            articleRepository.save(article);
//            addArticleNumberOnCategory(category.getCategory(),article);
        }
    }

    @Override
    public void removeCategory(int articleId, int categoryId) {
        Article article  = articleRepository.getById(articleId);
        Category category = categoryRepository.getById(categoryId);

        if (article == null || category == null) {
            return;
        }

        Set<Category> categorySet = article.getCategories();
        Set<Article> articleSet = category.getArticles();

        categorySet.remove(category);
        articleSet.remove(article);
        categoryRepository.save(category);
        articleRepository.save(article);
    }
}
