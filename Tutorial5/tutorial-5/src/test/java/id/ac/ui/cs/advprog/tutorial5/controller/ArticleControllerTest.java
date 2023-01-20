package id.ac.ui.cs.advprog.tutorial5.controller;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.service.ArticleService;
import id.ac.ui.cs.advprog.tutorial5.service.EditorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ArticleController.class)
public class ArticleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    private Article article;
    private Category category;
    private String articleTitle = "Artikel Baru";
    private String categoryName = "category name";
    private String articleText = "Artikel buatan orang keren";
    Set<Category> categories = new HashSet<>();

    @BeforeEach
    public void setUp() {
        category = new Category(categoryName,1);
        categories.add(category);
        article = new Article(articleTitle,articleText,categories);
    }

    @Test
    public void testPostArticle() throws Exception {
        when(articleService.createArticle(article)).thenReturn(article);

        mockMvc.perform(post("/article")
                        .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(article)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(articleTitle))
                .andExpect(jsonPath("$.text").value(articleText));
    }

    @Test
    public void testGetListArticle() throws Exception {
        Iterable<Article> articleList = List.of(article);
        when(articleService.getListArticle()).thenReturn(articleList);

        mockMvc.perform(get("/article").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value(articleTitle))
                .andExpect(jsonPath("$[0].text").value(articleText));
    }

    @Test
    public void testGetNonExistentEditorById() throws Exception {
        mockMvc.perform(get("/article/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetArticleById() throws Exception {
        when(articleService.getArticleById(0)).thenReturn(article);

        mockMvc.perform(get("/article/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value(articleTitle));
    }

    @Test
    public void testUpdateArticle() throws Exception {
        articleService.createArticle(article);
        String newArticleTitle = "Artikel Baru";
        article.setText(newArticleTitle);
        when(articleService.updateArticle(0, article)).thenReturn(article);

        mockMvc.perform(put("/article/0")
                        .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(article)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value(newArticleTitle));
    }

    @Test
    public void testDeleteArticleById() throws Exception {
        articleService.createArticle(article);

        mockMvc.perform(delete("/article/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
