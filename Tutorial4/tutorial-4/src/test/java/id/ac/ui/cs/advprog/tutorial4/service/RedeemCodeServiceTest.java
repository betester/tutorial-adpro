package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.code.GiveawayCode;
import id.ac.ui.cs.advprog.tutorial4.core.code.PromoCode;
import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode;
import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RedeemCodeServiceTest {
    @Mock
    RedeemCode redeemCode;

    @Mock
    private RedeemCodeRepository redeemCodeRepository;
    RedeemCodeServiceImpl redeemCodeService;

    @BeforeEach
    public void setup() {
        redeemCodeService = new RedeemCodeServiceImpl(redeemCodeRepository);
    }

    @Test
    public void whenRedeemCodeShouldCallFindByCode() throws Exception {
        when(redeemCodeRepository.findByCode("test")).thenReturn(redeemCode);
        redeemCodeService.redeemCode("test");
        verify(redeemCodeRepository, times(1)).findByCode("test");
    }

    @Test
    public void whenRedeemCodeErrorShouldReturnString() throws Exception {
        when(redeemCodeRepository.findByCode("test")).thenReturn(null);
        String res = redeemCodeService.redeemCode("test");
        verify(redeemCodeRepository, times(1)).findByCode("test");
        assertEquals("Redeem code with test does not exists!", res);

    }

    @Test
    public void whenRedeemCodeByPromoCodeTwoRequestShouldNotAcceptTwice() throws Exception {
        PromoCode promoCode = mock(PromoCode.class, CALLS_REAL_METHODS);
        Item item = mock(Item.class);
        ReflectionTestUtils.setField(promoCode,"code","testCode");
        ReflectionTestUtils.setField(promoCode,"discountAmount",12.1);
        ReflectionTestUtils.setField(promoCode,"item",item);

        when(redeemCodeRepository.findByCode("test")).thenReturn(promoCode);
        when(item.getName()).thenReturn("testItem");

        class Run implements Runnable {
            private String result;

            public void run() {
                result = redeemCodeService.redeemCode("test");
            }

            public String getValue() throws InterruptedException {
                return result;
            }
        };

        Run run = new Run();
        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run);

        thread1.start();
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        String result = run.getValue();
        thread2.join();
        String result2 = run.getValue();


        String expected1 = "Congratulation! You get a " + 12.1 + "% discount on " + "testItem";
        String expected2 = "Redeem code " + "testCode" + " has been redeemed and can't be used anymore.";

        assertEquals(expected1,result);
        assertEquals(expected2,result2);

    }

    @Test
    public void whenRedeemCodeByGiveawayCodeTwoRequestShouldNotAcceptTwice() throws Exception {
        GiveawayCode giveawayCode = mock(GiveawayCode.class, CALLS_REAL_METHODS);
        Item item = mock(Item.class);
        ReflectionTestUtils.setField(giveawayCode,"code","testCode");
        ReflectionTestUtils.setField(giveawayCode,"itemAmount",10);
        ReflectionTestUtils.setField(giveawayCode,"item",item);

        when(redeemCodeRepository.findByCode("test")).thenReturn(giveawayCode);
        when(item.getName()).thenReturn("testItem");

        class Run implements Runnable {
            private String result;

            public void run() {
                result = redeemCodeService.redeemCode("test");
            }

            public String getValue() throws InterruptedException {
                return result;
            }
        };

        Run run = new Run();
        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run);

        thread1.start();
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        String result = run.getValue();
        thread2.join();
        String result2 = run.getValue();

        String expected1 = "Congratulation! You get " + 10 + " " + "testItem";
        String expected2 = "Redeem code " + "testCode" + " has been redeemed and can't be used anymore.";

        assertEquals(expected1,result);
        assertEquals(expected2,result2);

    }

}


