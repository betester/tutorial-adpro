package id.ac.ui.cs.advancedprogramming.controlwand.controller;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;
import id.ac.ui.cs.advancedprogramming.controlwand.service.ControlWandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.EnumSet;
import java.util.List;

@Controller
public class WandController {
    @Autowired
    private ControlWandService service;

    @RequestMapping(path = "/control-wand", method = RequestMethod.GET)
    public String controlWand(Model model) {
        model.addAttribute("spellNames", service.getSpellNames());
        model.addAttribute("entities", service.getMagicalEntities());
        return "controlwand/control_wand";
    }

    @RequestMapping(path = "/contract-form", method = RequestMethod.GET)
    public String contractForm(Model model) {
        model.addAttribute("manaIntensities", ManaIntensity.getNonNullManaIntensities());
        return "controlwand/contract_form";
    }

    @RequestMapping(path = "/cast", method = RequestMethod.POST)
    public String castSpell(@RequestParam(value = "spellName") String spellName) {
        service.castSpell(spellName);
        return "redirect:/control-wand";
    }

    @RequestMapping(path = "/buy-magictool", method = RequestMethod.POST)
    public String contract(@RequestParam(value = "requiredSpells", required = false)
                                       List<ManaIntensity> requiredSpells,
                           @RequestParam(value = "name") String name) {
        if (requiredSpells != null)
            service.buyMagicTool(name, EnumSet.copyOf(requiredSpells));
        return "redirect:/control-wand";
    }

    @RequestMapping(path = "/contract-familiar", method = RequestMethod.POST)
    public String contract(@RequestParam(value = "name") String name) {
        service.contractFamiliar(name);
        return "redirect:/control-wand";
    }

    @RequestMapping(path = "/undo", method = RequestMethod.GET)
    public String undoSpell() {
        service.undoSpell();
        return "redirect:/control-wand";
    }

}
