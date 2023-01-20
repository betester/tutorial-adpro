package id.ac.ui.cs.advprog.tutorial9.service;

import id.ac.ui.cs.advprog.tutorial9.model.Article;
import id.ac.ui.cs.advprog.tutorial9.model.Category;
import id.ac.ui.cs.advprog.tutorial9.repository.CategoryRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    private boolean alreadyCalled = false;
    private List<Category> allCat;

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Iterable<Category> getListCategory() {

        // get most Recent Article
        if (!alreadyCalled) {
            allCat = categoryRepository.findAll();
            for (var cat : allCat) {
                Article mostRecent = cat.getArticles().get(0);
                for (var art : cat.getArticles()) {
                    if (art.getCreatedAt().getTime() > mostRecent.getCreatedAt().getTime()) {
                        mostRecent = art;
                    }
                }

                cat.setMostRecentArticle(mostRecent.getJudul());
                cat.setNumArticles(cat.getArticles().size());
            }
            alreadyCalled = true;
        }
        return allCat;
    }

}
