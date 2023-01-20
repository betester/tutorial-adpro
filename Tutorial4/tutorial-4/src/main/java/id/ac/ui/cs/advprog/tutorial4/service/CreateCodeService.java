package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.CodeType;
import id.ac.ui.cs.advprog.tutorial4.core.code.GiveawayCode;
import id.ac.ui.cs.advprog.tutorial4.core.code.PromoCode;
import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;

import java.util.Map;

public interface CreateCodeService {
    /**
     * Create RedeemCode
     * @param itemType String of {@link ItemType}.
     * @param codeType String of {@link CodeType}.
     * @param code Custom code
     * @param item Name of the item
     * @param data Map of additional data.
     *             Key "amount" should exist for Giveaway (see {@link GiveawayCode#getItemAmount()}).
     *             Key "discount" should exist for Promo (see {@link PromoCode#getDiscountAmount()}).
     *
     * @return {@link RedeemCode}
     */
    RedeemCode createCode(String itemType, String codeType, String code, String item, Map<String, String> data);
}
