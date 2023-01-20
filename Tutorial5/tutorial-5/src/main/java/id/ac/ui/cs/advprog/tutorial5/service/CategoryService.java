package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Category;


public interface CategoryService {
    Iterable<Category> getListCategory();


    Category createCategory(Category category);

    Category getCategoryById(int id);

    Category getCategoryByName(String name);


    Category updateCategory(int id, Category category);

    void deleteCategoryById(int id);

    boolean isAlreadyAdded(String name);


    void addSubCategory(int id, Category category);

    void removeSubCategoryById(int superCategoryId, int subCategoryId);
}
