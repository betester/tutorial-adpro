package id.ac.ui.cs.advprog.tutorial5.controller;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.service.ArticleService;
import id.ac.ui.cs.advprog.tutorial5.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity postArticle(@RequestBody Article article) {
        return ResponseEntity.ok(articleService.createArticle(article));
    }

    @PostMapping(path= "/{id}/addCategory", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity addCategory(@PathVariable(value = "id") int id, @RequestBody Category category) {
        //TODO :
        // handle kasus dimana kalau udah ada sebelumnya, tinggal add berdasarkan kategori itu
        articleService.addCategory(id,category);
        return ResponseEntity.ok("category has been added");
    }

    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Article>> getListArticle() {
        return ResponseEntity.ok(articleService.getListArticle());
    }
    @GetMapping(path = "/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getArticle(@PathVariable(value = "id") int id) {
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(article);
    }

    @PutMapping(path = "/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateArticle(@PathVariable(value = "id") int id, @RequestBody Article article) {
        return ResponseEntity.ok(articleService.updateArticle(id, article));
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity deleteArticle(@PathVariable(value = "id") int id) {
        articleService.deleteArticleById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{articleId}/{categoryId}", produces = {"application/json"})
    public ResponseEntity deleteCategoryFromArticle(@PathVariable(value = "articleId") int articleId,@PathVariable(value = "categoryId") int categoryId) {

        articleService.removeCategory(articleId,categoryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
