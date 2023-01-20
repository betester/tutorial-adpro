package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceImplTest {
    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ArticleServiceImpl articleService;

    private Article article;

    private Category category;

    private Set<Category> categorySet;

    private Set<Article> articleSet;

    @BeforeEach
    public void setUp() {
        String articleTitle = "judul artikel";
        String text  = "artikel ini adalah";
        String categoryName = "Action";
        int categoryNumArticles = 0;
        category = new Category(categoryName, categoryNumArticles);
        categorySet = new HashSet<>();
        articleSet = new HashSet<>();
        article = new Article(articleTitle,text,categorySet);
        category.setId(0);
    }

    @Test
    public void testGetArticleById() {
        lenient().when(articleService.getArticleById(0)).thenReturn(article);
        Article calledArticle = articleService.getArticleById(0);
        assertEquals(calledArticle.getId(), category.getId());
    }

    @Test
    public void testGetListArticle() {
        Iterable<Article> articleList = articleRepository.findAll();
        lenient().when(articleService.getListArticle()).thenReturn(articleList);
        Iterable<Article> articleListResult = articleService.getListArticle();
        assertIterableEquals(articleList, articleListResult);
    }

    @Test
    public void testCreateArticle() {
        lenient().when(articleService.createArticle(article)).thenReturn(article);
    }

    @Test
    public void testUpdateArticle() {
        articleService.createArticle(article);
        String title = article.getTitle();

        String newTitle = "salah judul";
        article.setTitle(newTitle);

        lenient().when(articleService.updateArticle(article.getId(),article)).thenReturn(article);
        Article articleResult = articleService.updateArticle(article.getId(), article);

        assertEquals(articleResult.getId(), category.getId());
        assertNotEquals(articleResult.getTitle(), title);
    }

    @Test
    public void testDeleteArticleById() {
        articleService.createArticle(article);
        lenient().when(articleRepository.findById(0)).thenReturn(article);
        articleService.deleteArticleById(0);
        lenient().when(articleService.getArticleById(0)).thenReturn(null);
        assertNull(articleService.getArticleById(0));
    }

    @Test
    public void testDeleteNonExistentCategoryById() {
        articleService.createArticle(article);
        lenient().when(articleRepository.findById(0)).thenReturn(null);
        articleService.deleteArticleById(0);
    }

    @Test
    public void testExistingCategory() {
        categoryRepository.save(category);
        lenient().when(categoryRepository.findByName(category.getName())).thenReturn(category);
        Category found = articleService.existingCategory(category);
        assertEquals(found,category);
    }

    @Test
    public void shouldNotRunSaveWhenCategoryIsNull() {
        articleService.addArticleNumberOnCategory(null,null);
        verify(articleRepository,never()).save(article);
    }

    @Test
    public void shouldNotRunSaveWhenArticleIsNull() {
        articleService.addArticleNumberOnCategory(null,null);
        verify(articleRepository,never()).save(article);
    }

    @Test
    public void shouldNotRunSaveWhenCategoryAlreadyInArticle() {
        categorySet.add(category);
        article.setCategories(categorySet);
        assertTrue(article.getCategories().contains(category));
        articleService.addArticleNumberOnCategory(category,article);
        verify(articleRepository,never()).save(article);
    }

    @Test
    public void shouldCallSaveWhenCategoryNotInArticle() {
        articleService.addArticleNumberOnCategory(category,article);
        assertEquals(1, article.getCategories().size());
        assertEquals(1, category.getArticles().size());
        verify(categoryRepository,times(1)).save(category);
        verify(articleRepository,times(1)).save(article);
    }

    @Test
    public void shouldNotSaveWhenArticleIsNull() {
        lenient().when(categoryRepository.getById(0)).thenReturn(category);
        articleService.removeCategory(0,0);
        verify(articleRepository,never()).save(article);
    }

    @Test
    public void shouldNotSaveWhenCategoryIsNull() {
        lenient().when(articleRepository.getById(0)).thenReturn(article);
        articleService.removeCategory(0,0);
        verify(articleRepository,never()).save(article);
    }


    @Test
    public void testAddCategory() {
        lenient().when(articleService.existingCategory(category)).thenReturn(category);
        when(articleRepository.getById(1)).thenReturn(article);
        articleService.addCategory(1,category);
    }

    @Test
    public void shouldRemoveWhenArticleAndCategoryIsNotNull() {
        article.setCategories(categorySet);
        categorySet.add(category);
        category.setArticles(articleSet);
        articleSet.add(article);
        lenient().when(categoryRepository.getById(0)).thenReturn(category);
        lenient().when(articleRepository.getById(0)).thenReturn(article);
        articleService.removeCategory(0,0);
        assertEquals(0, article.getCategories().size());
        assertEquals(0, category.getArticles().size());
        verify(categoryRepository,times(1)).save(category);
        verify(articleRepository,times(1)).save(article);
    }

}
