package id.ac.ui.cs.advprog.tutorial0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BaseController {
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index() {
        return "home";
    }

    @GetMapping("/greet")
    public String indexWithParam(@RequestParam("name")String name, Model model) {
        model.addAttribute("name",name);
        return "home";
    }

    @GetMapping("/greet/{name}")
    public String indexWithPathVariable(@PathVariable("name")String name, Model model) {
        model.addAttribute("name",name);
        return "home";
    }
}

