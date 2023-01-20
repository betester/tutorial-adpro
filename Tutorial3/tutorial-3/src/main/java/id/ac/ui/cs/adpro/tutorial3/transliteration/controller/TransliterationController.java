package id.ac.ui.cs.adpro.tutorial3.transliteration.controller;

import id.ac.ui.cs.adpro.tutorial3.transliteration.service.TransliterationService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/linguamorphism")
public class TransliterationController {

    @Autowired
    private TransliterationService transliterationService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    private String home() {
        return "transliteration/translateForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/parseLanguage")
    private String translateForm(HttpServletRequest request) {
        String type = request.getParameter("type");
        String text = request.getParameter("text");
        transliterationService.setRequestType(type);
        transliterationService.setRequestValue(text);
        return "redirect:/linguamorphism/translate";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/translate")
    private String processText(Model model) {
        boolean isEncode = transliterationService.isRequestEncode();
        String value = transliterationService.getRequestValue();
        model.addAttribute("inputType", isEncode ? "Text" : "Encoded");
        model.addAttribute("input", value);
        model.addAttribute("result",
            isEncode ? transliterationService.encode(value) : transliterationService.decode(value));
        return "transliteration/result";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cipher")
    private String cipher(Model model, HttpServletRequest request) {
        String type = request.getParameter("ciphertype");
        String text = request.getParameter("ciphertext");

        String ret = transliterationService.processAeronCipher(text, type);

        model.addAttribute("ciphertextinput", text);
        model.addAttribute("ciphertextoutput", ret);
        model.addAttribute("action", type);

        return "transliteration/translateForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/shifter")
    private String shifter(Model model, HttpServletRequest request) {
        String shiftByStr = request.getParameter("shiftby");
        String text = request.getParameter("shiftertext");

        int shiftByInt;
        try {
            shiftByInt = Integer.parseInt(shiftByStr);

        } catch(NumberFormatException e) {
            return "transliteration/translateForm";
        }

        String ret = transliterationService.processAeronShifter(text, shiftByInt);

        model.addAttribute("shiftertextinput", text);
        model.addAttribute("shiftertextoutput", ret);
        model.addAttribute("shifterby", shiftByStr);

        return "transliteration/translateForm";
    }

}
