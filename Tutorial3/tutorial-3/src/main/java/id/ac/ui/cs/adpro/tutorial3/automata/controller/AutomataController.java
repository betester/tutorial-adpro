package id.ac.ui.cs.adpro.tutorial3.automata.controller;

import id.ac.ui.cs.adpro.tutorial3.automata.service.DroidService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/logistix")
public class AutomataController {

    @Autowired
    private DroidService droidService;

    @RequestMapping(method = RequestMethod.GET, path = "")
    public String useAutomata(Model model) {
        model.addAttribute("automatas", droidService.fetchDroids());
        model.addAttribute("logs", droidService.fetchLogs());
        return "automata/index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/inventory")
    public String inventory(Model model) {
        model.addAttribute("inventories", droidService.fetchInventories());
        return "automata/inventory";
    }

    @RequestMapping(path = "/do")
    public String doRoutine(
        @RequestParam(value = "unit") String unit,
        @RequestParam(value = "routine") int routine
    ) {
        droidService.doRoutine(unit, routine);
        return "redirect:/logistix";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addInventory")
    public String addInventory(HttpServletRequest request) {
        String item = request.getParameter("item");
        droidService.addInventory(item);
        return "redirect:/logistix/inventory";
    }
}
