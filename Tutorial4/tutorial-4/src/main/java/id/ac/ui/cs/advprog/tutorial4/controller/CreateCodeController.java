package id.ac.ui.cs.advprog.tutorial4.controller;

import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode;
import id.ac.ui.cs.advprog.tutorial4.model.dto.CreateCodeDTO;
import id.ac.ui.cs.advprog.tutorial4.service.CreateCodeService;
import id.ac.ui.cs.advprog.tutorial4.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/code/create")
@RequiredArgsConstructor
public class CreateCodeController {
    private final CreateCodeService createCodeService;
    private final ItemService itemService;

    @GetMapping({"", "/"})
    public String getCreatePage(Model model) {
        model.addAttribute("merchItems", itemService.getAllMerchItem());
        model.addAttribute("membershipItems", itemService.getAllMembershipItem());
        model.addAttribute("dto", new CreateCodeDTO());
        return "create";
    }

    @PostMapping( {"", "/"})
    public String createCode(CreateCodeDTO dto, Model model) {
        RedeemCode redeemCode = createCodeService.createCode(
                dto.getItemType(),
                dto.getCodeType(),
                dto.getCode(),
                dto.getItem(),
                dto.getData()
        );
        model.addAttribute("merchItems", itemService.getAllMerchItem());
        model.addAttribute("membershipItems", itemService.getAllMembershipItem());
        model.addAttribute("dto", new CreateCodeDTO());
        model.addAttribute("redeemCode", redeemCode);
        return "create";
    }
}
