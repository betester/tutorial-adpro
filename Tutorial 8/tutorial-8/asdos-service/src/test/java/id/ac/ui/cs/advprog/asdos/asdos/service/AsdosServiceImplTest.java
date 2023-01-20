package id.ac.ui.cs.advprog.asdos.asdos.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AsdosServiceImplTest {
//    @Mock
//    private AsdosRepository asdosRepository;
//
//    @InjectMocks
//    private AsdosServiceImpl categoryService;
//
//    private Category category;
//
//    @BeforeEach
//    public void setUp() {
//        String categoryName = "Action";
//        int categoryNumArticles = 0;
//        category = new Category(categoryName, categoryNumArticles);
//        category.setId(0);
//    }
//
//    @Test
//    public void testGetCategoryById() {
//        lenient().when(categoryService.getCategoryById(0)).thenReturn(category);
//        Category calledCategory = categoryService.getCategoryById(0);
//        assertEquals(calledCategory.getId(), category.getId());
//    }
//
//    @Test
//    public void testGetListCategory() {
//        Iterable<Category> categoryList = asdosRepository.findAll();
//        lenient().when(categoryService.getListCategory()).thenReturn(categoryList);
//        Iterable<Category> categoryListResult = categoryService.getListCategory();
//        assertIterableEquals(categoryList, categoryListResult);
//    }
//
//    @Test
//    public void testCreateCategory() {
//        lenient().when(categoryService.createCategory(category)).thenReturn(category);
//    }
//
//    @Test
//    public void testUpdateCategory() {
//        categoryService.createCategory(category);
//        String pastName = category.getName();
//
//        String newName = "Fantasy";
//        category.setName(newName);
//
//        lenient().when(categoryService.updateCategory(category.getId(), category)).thenReturn(category);
//        Category categoryResult = categoryService.updateCategory(category.getId(), category);
//
//        assertEquals(categoryResult.getId(), category.getId());
//        assertNotEquals(categoryResult.getName(), pastName);
//    }
//
//    @Test
//    public void testDeleteCategoryById() {
//        categoryService.createCategory(category);
//        lenient().when(asdosRepository.findById(0)).thenReturn(category);
//        categoryService.deleteCategoryById(0);
//        lenient().when(categoryService.getCategoryById(0)).thenReturn(null);
//        assertNull(categoryService.getCategoryById(0));
//    }
//
//    @Test
//    public void testDeleteNonExistentCategoryById() {
//        categoryService.createCategory(category);
//        lenient().when(asdosRepository.findById(0)).thenReturn(null);
//        categoryService.deleteCategoryById(0);
//    }
}
