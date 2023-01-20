package id.ac.ui.cs.advprog.tutorial5.controller;

import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity postCategory(@RequestBody Category category) {
            return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @PostMapping(path = "/{id}/addSubCategory",produces = {"application/json"})
    @ResponseBody
    public ResponseEntity addSubCategory(@PathVariable(value = "id") int id, @RequestBody Category category) {
        categoryService.addSubCategory(id,category);
        return ResponseEntity.ok("sub category successfully updated");
    }

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

    @PutMapping(path = "/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateCategory(@PathVariable(value = "id") int id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity deleteCategory(@PathVariable(value = "id") int id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{superCategoryId}/{subCategoryId}", produces = {"application/json"})
    public ResponseEntity deleteSubCategory(@PathVariable(value = "superCategoryId") int superCategoryId,
                                            @PathVariable(value = "subCategoryId") int subCategoryId) {
        categoryService.removeSubCategoryById(superCategoryId,subCategoryId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
