package id.ac.ui.cs.advprog.tutorial9.controller;

import id.ac.ui.cs.advprog.tutorial9.model.Category;
import id.ac.ui.cs.advprog.tutorial9.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Category>> getListCategory() {
        return ResponseEntity.ok(categoryService.getListCategory());
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getCategory(@PathVariable(value = "id") int id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category);
    }

}
