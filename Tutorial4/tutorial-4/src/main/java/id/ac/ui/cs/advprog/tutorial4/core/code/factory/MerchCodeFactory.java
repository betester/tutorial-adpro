package id.ac.ui.cs.advprog.tutorial4.core.code.factory;

import id.ac.ui.cs.advprog.tutorial4.core.code.*;
import id.ac.ui.cs.advprog.tutorial4.core.code.merch.MerchGiveawayCode;
import id.ac.ui.cs.advprog.tutorial4.core.code.merch.MerchPromoCode;
import id.ac.ui.cs.advprog.tutorial4.core.item.Item;

public class MerchCodeFactory implements CodeFactory {
    @Override
    public PromoCode createPromoCode(String code, Item item, double discountAmount) {
        return new MerchPromoCode(code,item,discountAmount);
    }

    @Override
    public GiveawayCode createGiveAwayCode(String code, Item item, int itemAmount) {
        return new MerchGiveawayCode(code,item,itemAmount);
    }
}
