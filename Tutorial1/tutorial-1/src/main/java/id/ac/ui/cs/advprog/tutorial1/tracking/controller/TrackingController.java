package id.ac.ui.cs.advprog.tutorial1.tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.RoadUser;
import id.ac.ui.cs.advprog.tutorial1.tracking.service.TrackingService;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping(path = "/tracking")
public class TrackingController {
    
    @Autowired
    private TrackingService trackingService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String trackingHome(Model model) {
        
        List<RoadUser> ret = trackingService.getRoadUsers();
        model.addAttribute("roadUsers", ret);

        return "tracking/home";
    }

    @RequestMapping(path = "/new-drago-location", method = RequestMethod.POST)
    public String handleNewDrago(Model model, 
                                @RequestParam(value = "dragoLocation", required = true) String dragoLocation) {
        
    
        trackingService.handleNewEventLocation("Drago Monitor",dragoLocation);
        return "redirect:/tracking";
    }

    @RequestMapping(path = "/new-sweets-location", method = RequestMethod.POST)
    public String handleNewSweets(Model model, 
                                @RequestParam(value = "sweetsLocation", required = true) String sweetsLocation) {
        
    
        trackingService.handleNewEventLocation("Sweets Monitor",sweetsLocation);

        return "redirect:/tracking";
    }
}
