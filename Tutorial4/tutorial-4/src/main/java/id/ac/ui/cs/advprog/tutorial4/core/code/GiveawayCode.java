package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// DO NOT TOUCH
public abstract class GiveawayCode implements RedeemCode {
    private final String code;
    private final Item item;
    private final int itemAmount;

    private boolean redeemed = false;

    protected GiveawayCode(String code, Item item, int itemAmount) {
        this.code = code;
        this.item = item;
        this.itemAmount = itemAmount;

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
                return "Congratulation! You get " + getItemAmount() + " " + getItem().getName();
            }
        } catch (Exception e) {
            return "Redeeming code " + getCode() + " failed with unknown cause.";
        }
    }

    public Item getItem() {
        return this.item;
    }

    public int getItemAmount() {
        return this.itemAmount;
    }

}
