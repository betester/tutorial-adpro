package id.ac.ui.cs.advprog.tutorial7.core.async;

import id.ac.ui.cs.advprog.tutorial7.core.vaapi.VAHelper;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class VAAmountHelperAsync implements Supplier<Integer> {

    private final VAHelper helper;
    private final String va;

    public VAAmountHelperAsync(VAHelper helper, String va) {
        this.helper = helper;
        this.va = va;
    }


    @Override
    public Integer get() {
        try {
            return helper.getVAAmount(va);
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }
}
