package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;

// DO NOT TOUCH
public abstract class PromoCode implements RedeemCode {
    private final String code;
    private final Item item;
    private final double discountAmount;

    private boolean redeemed = false;

    protected PromoCode(String code, Item item, double discountAmount) {
        this.code = code;
        this.item = item;
        this.discountAmount = discountAmount;
    }

    @Override
    public final String getCode() {
        return code;
    }

    @Override
    public final boolean isRedeemed() {
        return redeemed;
    }

    @Override
    public final String redeem() {
        try {
            if (this.redeemed) {
                return "Redeem code " + this.getCode() + " has been redeemed and can't be used anymore.";
            } else {
                Thread.sleep(5000);
                this.redeemed = true;
                return "Congratulation! You get a " + getDiscountAmount() + "% discount on " + getItem().getName();
            }
        } catch (Exception e) {
            return "Redeeming code " + getCode() + " failed with unknown cause.";
        }

    }

    public Item getItem() {
        return this.item;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

}