package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Category;
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
public class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;

    private Category superCategory;

    @BeforeEach
    public void setUp() {
        String categoryName = "Action";
        String superCategoryName = "Thriller";
        int superCategoryNumArticles = 0;
        int categoryNumArticles = 0;
        category = new Category(categoryName, categoryNumArticles);
        superCategory = new Category(superCategoryName,superCategoryNumArticles);
        category.setId(0);
    }

    @Test
    public void testGetCategoryById() {
        lenient().when(categoryService.getCategoryById(0)).thenReturn(category);
        Category calledCategory = categoryService.getCategoryById(0);
        assertEquals(calledCategory.getId(), category.getId());
    }

    @Test
    public void testGetListCategory() {
        Iterable<Category> categoryList = categoryRepository.findAll();
        lenient().when(categoryService.getListCategory()).thenReturn(categoryList);
        Iterable<Category> categoryListResult = categoryService.getListCategory();
        assertIterableEquals(categoryList, categoryListResult);
    }

    @Test
    public void testCreateCategory() {
        lenient().when(categoryService.createCategory(category)).thenReturn(category);
    }

    @Test
    public void testUpdateCategory() {
        categoryService.createCategory(category);
        String pastName = category.getName();

        String newName = "Fantasy";
        category.setName(newName);

        lenient().when(categoryService.updateCategory(category.getId(), category)).thenReturn(category);
        Category categoryResult = categoryService.updateCategory(category.getId(), category);

        assertEquals(categoryResult.getId(), category.getId());
        assertNotEquals(categoryResult.getName(), pastName);
    }

    @Test
    public void testDeleteCategoryById() {
        categoryService.createCategory(category);
        lenient().when(categoryRepository.findById(0)).thenReturn(category);
        categoryService.deleteCategoryById(0);
        lenient().when(categoryService.getCategoryById(0)).thenReturn(null);
        assertNull(categoryService.getCategoryById(0));
    }

    @Test
    public void testDeleteNonExistentCategoryById() {
        categoryService.createCategory(category);
        lenient().when(categoryRepository.findById(0)).thenReturn(null);
        categoryService.deleteCategoryById(0);
    }

    @Test
    public void testGetCategoryByName() {
        categoryService.getCategoryByName(category.getName());
        verify(categoryRepository, times(1)).findByName(category.getName());
    }

    @Test
    public void shouldReturnFalseWhenThereIsTheCategory() {
        lenient().when(categoryService.getCategoryByName(category.getName())).thenReturn(category);
        boolean check = categoryService.isAlreadyAdded(category.getName());
        assertFalse(check);
    }

    @Test
    public void shouldReturnTrueWhenThereIsNoCategory() {
        lenient().when(categoryService.getCategoryByName(category.getName())).thenReturn(null);
        boolean check = categoryService.isAlreadyAdded(category.getName());
        assertTrue(check);
    }

    @Test
    public void shouldNotCallSaveWhenTheCategoryIsNull() {
        categoryService.addSubCategory(0,null);
        verify(categoryRepository,never()).save(category);
    }

    @Test
    public void shouldNotCallSaveWhenTheSuperCategoryIsNull() {
        lenient().when(categoryService.getCategoryById(0)).thenReturn(null);
        categoryService.addSubCategory(0,category);
        verify(categoryRepository,never()).save(category);
    }

    @Test
    public void shouldCallSaveWhenTheIdAndTheCategoryExist() {
        lenient().when(categoryService.getCategoryById(0)).thenReturn(superCategory);
        lenient().when(categoryService.getCategoryByName(category.getName())).thenReturn(category);
        categoryService.addSubCategory(0,category);
        assertNotEquals(category.getCategory(), null);
        verify(categoryRepository,times(1)).save(category);
        verify(categoryRepository,times(1)).save(superCategory);

    }

    @Test
    public void shouldReturnTrueWhenTheCategoryIsAlreadyAdded() {
        lenient().when(categoryService.getCategoryByName(category.getName())).thenReturn(category);
        boolean check = categoryService.defaultAddSubCategory(null,category);
        assertTrue(check);
    }

    @Test
    public void shouldSaveAndSetCategoryAndReturnFalseWhenTheCategoryIsNotAdded() {
        Category superCategory = new Category("thriller",0);
        lenient().when(categoryService.getCategoryByName(category.getName())).thenReturn(null);
        categoryService.defaultAddSubCategory(superCategory,category);
        verify(categoryRepository,times(1)).save(category);
        verify(categoryRepository,times(1)).save(superCategory);
        assertNotEquals(category.getCategory(), null);
    }

    @Test
    public void shouldNotSaveWhenSuperCategoryDoesNotHaveCategory() {
        Set<Category> categorySet = new HashSet<>();
        superCategory.setCategories(categorySet);
        lenient().when(categoryRepository.getById(0)).thenReturn(superCategory);
        lenient().when(categoryRepository.getById(1)).thenReturn(category);
        categoryService.removeSubCategoryById(0,1);
        verify(categoryRepository,never()).save(category);
    }

    @Test
    public void shouldSaveWhenSuperCategoryHaveCategory() {
        Set<Category> categorySet = new HashSet<>();
        categorySet.add(category);
        superCategory.setCategories(categorySet);
        lenient().when(categoryRepository.getById(0)).thenReturn(superCategory);
        lenient().when(categoryRepository.getById(1)).thenReturn(category);
        categoryService.removeSubCategoryById(0,1);
        verify(categoryRepository,times(1)).save(category);
    }

}
