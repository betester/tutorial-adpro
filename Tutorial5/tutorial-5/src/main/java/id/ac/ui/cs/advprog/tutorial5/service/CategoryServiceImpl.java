package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Iterable<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        category.setId(id);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategoryById(int id) {
        Category category = this.getCategoryById(id);
        if(category != null)
            categoryRepository.delete(category);
    }

    @Override
    public boolean isAlreadyAdded(String name) {
        Category categoryByName = getCategoryByName(name);
        return categoryByName == null;
    }

    @Override
    public void addSubCategory(int id, Category category) {
        if (category == null) {
            return;
        }

        Category category1 = getCategoryById(id);

        if (category1 == null) {
            return;
        }

        if (defaultAddSubCategory(category1,category)) {
            Category childCategory = getCategoryByName(category.getName());
            childCategory.setCategory(category1);
            categoryRepository.save(category1);
            categoryRepository.save(childCategory);
        }
    }

    public boolean defaultAddSubCategory(Category superCategory, Category subCategory) {
        if (!isAlreadyAdded(subCategory.getName())) {
            return true;
        }
        subCategory.setCategory(superCategory);
        createCategory(subCategory);
        categoryRepository.save(superCategory);
        return false;
    }

    @Override
    public void removeSubCategoryById(int superCategoryId, int subCategoryId) {
        Category superCategory = categoryRepository.getById(superCategoryId);
        Category subCategory = categoryRepository.getById(subCategoryId);
        boolean contain = superCategory.getCategories().contains(subCategory);

        if (contain) {
            subCategory.setCategory(null);
            categoryRepository.save(subCategory);
        }


    }


}
