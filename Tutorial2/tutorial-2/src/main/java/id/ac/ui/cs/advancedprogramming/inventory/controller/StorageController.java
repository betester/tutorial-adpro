package id.ac.ui.cs.advancedprogramming.inventory.controller;

import id.ac.ui.cs.advancedprogramming.inventory.core.DummyType;
import id.ac.ui.cs.advancedprogramming.inventory.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StorageController {
    @Autowired
    private StorageService service;

    @RequestMapping(path = "/dummy-inventory")
    public String dummyStorage(Model model) {
        model.addAttribute("dummies", service.getDummies());
        model.addAttribute("dummyTypes", DummyType.values());
        return "inventory/dummy_inventory";
    }

    @RequestMapping(path = "/dummy-inventory/{index}")
    public String dummyBio(@PathVariable("index") int index,
                           Model model) {
        model.addAttribute("dummy", service.getDummy(index));
        model.addAttribute("dummyIndex", index);
        return "inventory/dummy_bio";
    }

    @RequestMapping(path = "/store-dummy", method = RequestMethod.POST)
    public String storeDummy(@RequestParam(value = "weight") float weight,
                            @RequestParam(value = "dummyType") DummyType dummyType,
                            @RequestParam(value = "weapon") String weapon) {
        service.createDummy(weight, dummyType, weapon);
        return "redirect:/dummy-inventory";
    }

    @RequestMapping(path = "/remove-dummy/{index}", method = RequestMethod.DELETE)
    public String removeDummy(@PathVariable("index") int index) {
        service.removeDummy(index);
        return "redirect:/dummy-inventory";
    }
}
