package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.*;
import id.ac.ui.cs.advprog.tutorial4.core.code.factory.MembershipCodeFactory;
import id.ac.ui.cs.advprog.tutorial4.core.code.factory.MerchCodeFactory;
import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.util.RedeemCodeUtil;
import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import id.ac.ui.cs.advprog.tutorial4.repository.RedeemCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CreateCodeServiceImpl implements CreateCodeService {
    final RedeemCodeRepository redeemCodeRepository;
    final ItemRepository itemRepository;
    CodeFactory codeFactory;
    ItemType itemType1;
    String generatedCode = RedeemCodeUtil.generateCode();
    RedeemCode redeemCode = null;
    @Override
    public RedeemCode createCode(String itemType, String codeType, String code, String itemName, Map<String, String> data) {
        if (itemType.equals("merch")) {
            codeFactory = new MerchCodeFactory();
            itemType1 = ItemType.MERCH;
        }
        else if(itemType.equals("membership")){
            codeFactory = new MembershipCodeFactory();
            itemType1 = ItemType.MEMBERSHIP;
        }

        if (!code.isEmpty())
            generatedCode = code;

        Item selectedItem = itemRepository.findByNameAndType(itemName,itemType1);

        switch (codeType) {
            case "promo" :
                double itemDiscount = Double.parseDouble(data.get("discount"));
                redeemCode = codeFactory.createPromoCode(generatedCode,selectedItem,itemDiscount);
                break;

            case "giveaway":
                int itemCount = Integer.parseInt(data.get("amount"));
                redeemCode = codeFactory.createGiveAwayCode(code,selectedItem,itemCount);
                break;
        }

        redeemCodeRepository.save(redeemCode);
        return redeemCode;
    }
}
