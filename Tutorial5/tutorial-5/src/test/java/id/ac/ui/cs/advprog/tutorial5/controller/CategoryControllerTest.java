package id.ac.ui.cs.advprog.tutorial5.controller;

import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CategoryController.class)
public class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    private Category category;
    private final String categoryName = "Action";
    private final int categoryNumArticles = 0;

    @BeforeEach
    public void setUp() {
        category = new Category(categoryName, categoryNumArticles);
    }

    @Test
    public void testPostCategory() throws Exception {
        when(categoryService.createCategory(category)).thenReturn(category);

        mockMvc.perform(post("/category")
                .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(category)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(categoryName))
                .andExpect(jsonPath("$.numArticles").value(categoryNumArticles));
    }

    @Test
    public void testGetListCategory() throws Exception {
        Iterable<Category> categoriesList = List.of(category);
        when(categoryService.getListCategory()).thenReturn(categoriesList);

        mockMvc.perform(get("/category").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value(categoryName))
                .andExpect(jsonPath("$[0].numArticles").value(categoryNumArticles));
    }

    @Test
    public void testGetNonExistentCategoryById() throws Exception {
        mockMvc.perform(get("/category/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetCategoryById() throws Exception {
        when(categoryService.getCategoryById(0)).thenReturn(category);

        mockMvc.perform(get("/category/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(categoryName));
    }

    @Test
    public void testUpdateCategory() throws Exception {
        categoryService.createCategory(category);
        String newCategoryName = "Fantasy";
        category.setName(newCategoryName);
        when(categoryService.updateCategory(0, category)).thenReturn(category);

        mockMvc.perform(put("/category/0")
                .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(category)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(newCategoryName));
    }

    @Test
    public void testDeleteCategoryById() throws Exception {
        categoryService.createCategory(category);

        mockMvc.perform(delete("/category/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
