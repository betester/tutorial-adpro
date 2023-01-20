package id.ac.ui.cs.advprog.tutorial9.service;

import id.ac.ui.cs.advprog.tutorial9.model.Category;

public interface CategoryService {
    Iterable<Category> getListCategory();
    
    Category getCategoryById(int id);

}
