package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;

public interface CodeFactory {
    PromoCode createPromoCode(String code, Item item, double discountAmount);
    GiveawayCode createGiveAwayCode(String code,Item item, int itemAmount);
}
