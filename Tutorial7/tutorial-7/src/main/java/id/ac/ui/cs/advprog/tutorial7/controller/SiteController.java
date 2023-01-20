package id.ac.ui.cs.advprog.tutorial7.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class SiteController {
    
    @GetMapping({"/", ""})
    public String getHomePage(Model model) {
        return "homepage";
    }

    @GetMapping("/payment")
    public String getPaymentPage(Model model) {
        return "payment";
    }

}
