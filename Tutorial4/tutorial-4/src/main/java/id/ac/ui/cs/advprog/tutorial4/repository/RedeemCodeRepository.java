package id.ac.ui.cs.advprog.tutorial4.repository;

import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RedeemCodeRepository {
    private final Map<String, RedeemCode> redeemCodeMap = new HashMap<>();

    public Collection<RedeemCode> findAll() {
        return this.redeemCodeMap.values();
    }

    public RedeemCode save(RedeemCode redeemCode) {
        redeemCodeMap.put(redeemCode.getCode(), redeemCode);
        return redeemCode;
    }

    public RedeemCode findByCode(String code) {
        return redeemCodeMap.get(code);
    }
}
