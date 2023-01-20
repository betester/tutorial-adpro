package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.GiveawayCode;
import id.ac.ui.cs.advprog.tutorial4.core.code.factory.MembershipCodeFactory;
import id.ac.ui.cs.advprog.tutorial4.core.code.factory.MerchCodeFactory;
import id.ac.ui.cs.advprog.tutorial4.core.code.PromoCode;
import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import id.ac.ui.cs.advprog.tutorial4.repository.RedeemCodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCodeServiceTest {
    @Mock
    private RedeemCodeRepository redeemCodeRepository;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    Item item;

    private CreateCodeServiceImpl service;
    private Map<String,String> data;

    @BeforeEach
    public void setUp() {
        service = new CreateCodeServiceImpl(redeemCodeRepository,itemRepository);
        data = new HashMap<>();
        data.put("discount","10");
        data.put("amount","10");
    }

    @Test
    public void testCodeFactoryandItemTypeIsMerch() {
        service.createCode("merch","testingType","anycode","anyname",data);
        assert(service.codeFactory instanceof MerchCodeFactory);
        assert(service.itemType1.equals(ItemType.MERCH));
    }

    @Test
    public void testCodeFactoryandItemTypeIsMembership() {
        service.createCode("membership","testingType","anycode","anyname",data);
        assert(service.codeFactory instanceof MembershipCodeFactory);
        assert(service.itemType1.equals(ItemType.MEMBERSHIP));
    }

    @Test
    public void testRedeemCodeTypeIsPromoCode() {
        when(itemRepository.findByNameAndType("anyname",ItemType.MEMBERSHIP)).thenReturn(item);
        service.createCode("membership","promo","anycode","anyname",data);
        assert(service.redeemCode instanceof PromoCode);
    }

    @Test
    public void testRedeemCodeTypeIsGiveawayCode() {
        when(itemRepository.findByNameAndType("anyname",ItemType.MEMBERSHIP)).thenReturn(item);
        service.createCode("membership","giveaway","anycode","anyname",data);
        assert(service.redeemCode instanceof GiveawayCode);
    }
}
