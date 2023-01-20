package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode;
import id.ac.ui.cs.advprog.tutorial4.repository.RedeemCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedeemCodeServiceImpl implements RedeemCodeService {

    private final RedeemCodeRepository redeemCodeRepository;

    @Override
    public String redeemCode(String code)  {
        RedeemCode redeemCode = redeemCodeRepository.findByCode(code);
        if (redeemCode == null)
            return "Redeem code with " + code + " does not exists!";
        synchronized (redeemCode) {
            return redeemCode.redeem();
        }
    }
}
