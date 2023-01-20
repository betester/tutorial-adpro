package id.ac.ui.cs.advprog.tutorial4.core.code.factory;

import id.ac.ui.cs.advprog.tutorial4.core.code.*;
import id.ac.ui.cs.advprog.tutorial4.core.code.membership.MembershipGiveawayCode;
import id.ac.ui.cs.advprog.tutorial4.core.code.membership.MembershipPromoCode;
import id.ac.ui.cs.advprog.tutorial4.core.item.Item;


public class MembershipCodeFactory implements CodeFactory {
    @Override
    public PromoCode createPromoCode(String code, Item item, double discountAmount) {
        return new MembershipPromoCode(code,item,discountAmount);
    }

    @Override
    public GiveawayCode createGiveAwayCode(String code, Item item, int itemAmount) {
        return new MembershipGiveawayCode(code,item,itemAmount);
    }
}
