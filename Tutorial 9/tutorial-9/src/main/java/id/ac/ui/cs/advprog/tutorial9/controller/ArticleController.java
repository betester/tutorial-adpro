package id.ac.ui.cs.advprog.tutorial9.controller;

import id.ac.ui.cs.advprog.tutorial9.model.Article;
import id.ac.ui.cs.advprog.tutorial9.model.ArticleView;
import id.ac.ui.cs.advprog.tutorial9.model.Category;
import id.ac.ui.cs.advprog.tutorial9.service.ArticleService;
import id.ac.ui.cs.advprog.tutorial9.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "api/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping(path="/views/{date}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<ArticleView>> getArticleViewByDate(@PathVariable(value="date") String date, 
                                                                      @RequestParam(value="page") int page,
                                                                      @RequestParam(value="limit") int limit) {
        
        return ResponseEntity.ok(articleService.getArticleViewByDate(date, page, limit));
    }

    @GetMapping(path="", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Article>> listArticle(@RequestParam(value="page") int page,  
                                                         @RequestParam(value="limit") int limit) {
        
        return ResponseEntity.ok(articleService.getListArticle(page, limit));
    }

    @GetMapping(path="/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getArticleByID(@PathVariable(value = "id") int articleID) {
        
        return ResponseEntity.ok(articleService.getArticleById(articleID));
    }
}
