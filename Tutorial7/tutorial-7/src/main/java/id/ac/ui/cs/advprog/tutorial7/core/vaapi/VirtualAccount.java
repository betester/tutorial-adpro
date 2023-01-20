package id.ac.ui.cs.advprog.tutorial7.core.vaapi;

import lombok.Data;

// DO NOT TOUCH
@Data
public class VirtualAccount {
    private String va;
    private int vaAmount;
    private String bank;
    private  boolean isPayed;

    public VirtualAccount(String _va, int _vaAmount, String _bank) {
        va = _va;
        vaAmount = _vaAmount;
        bank = _bank;
        isPayed = false;
    }

    public void setIsPayed(boolean isPayed) {this.isPayed = isPayed;}
    public boolean getIsPayed() {return isPayed;}
}
