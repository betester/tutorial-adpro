package id.ac.ui.cs.advprog.tutorial1.pricing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import id.ac.ui.cs.advprog.tutorial1.pricing.service.PricingService;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping(path = "/pricing")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String pricingHome(Model model) {
        return "pricing/home";
    }

    @RequestMapping(path = "/calculate-price", method= RequestMethod.POST)
    public String calculatePrice(Model model,
            @RequestParam(value = "weight", required = true) int weight,
            @RequestParam(value = "value", required = true) int value) {
        

        List<String> ret = pricingService.calculatePrice(weight,value);

        model.addAttribute("logs", ret);

        return "pricing/home";
    }

}