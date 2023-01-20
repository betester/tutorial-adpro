package id.ac.ui.cs.advprog.tutorial9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import id.ac.ui.cs.advprog.tutorial9.service.ArticleService;

@Controller
@RequestMapping(path = "")
public class PageController {
    
    @Autowired
    private ArticleService articleService;

    @GetMapping(path = {"/", ""})
    public String getHomePage(Model model) {
        return "homepage";
    }

    @GetMapping(path = "/article/{id}")
    public String getArticlePage(Model model, @PathVariable("id") int articleId) {
        var art = articleService.getArticleById(articleId);
        model.addAttribute("article", art);
        return "articleview";
    }

    @GetMapping(path = "/category")
    public String getPaymentPage(Model model) {
        return "category";
    }

    @GetMapping(path = "/views")
    public String getViewPage(Model model) {
        return "views";
    }

}
