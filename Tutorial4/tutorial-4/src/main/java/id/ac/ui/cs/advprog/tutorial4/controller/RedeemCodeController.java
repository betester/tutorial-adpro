package id.ac.ui.cs.advprog.tutorial4.controller;

import id.ac.ui.cs.advprog.tutorial4.model.dto.CreateCodeDTO;
import id.ac.ui.cs.advprog.tutorial4.model.dto.RedeemCodeDTO;
import id.ac.ui.cs.advprog.tutorial4.service.RedeemCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/code/redeem")
@RequiredArgsConstructor
public class RedeemCodeController {
    private final RedeemCodeService redeemCodeService;

    @GetMapping({"", "/"})
    public String getRedeemPage(Model model) {
        model.addAttribute("dto", new RedeemCodeDTO());
        return "redeem";
    }

    @PostMapping({"", "/"})
    public String redeemCode(RedeemCodeDTO dto, Model model) {
        String redeemResult = redeemCodeService.redeemCode(dto.getCode());
        model.addAttribute("dto", new RedeemCodeDTO());
        model.addAttribute("redeemResult", redeemResult);
        return "redeem";
    }
}
