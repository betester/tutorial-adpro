package id.ac.ui.cs.advprog.tutorial4.repository;

import id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RedeemCodeRepositoryTest {

    private RedeemCodeRepository redeemCodeRepository;

    @Mock
    private RedeemCode redeemCode;

    @Mock
    private RedeemCode redeemCode1;


    @BeforeEach
    public void setUp() {
        redeemCodeRepository = new RedeemCodeRepository();
        when(redeemCode.getCode()).thenReturn("test");
        redeemCodeRepository.save(redeemCode);
    }

    @Test
    public void whenSaveNewRedeemCodeShouldAddToRepository() throws Exception {
        when(redeemCode1.getCode()).thenReturn("test");
        redeemCodeRepository.save(redeemCode1);

        Collection<RedeemCode> redeemCodes = redeemCodeRepository.findAll();
        assertThat(redeemCodes).hasSize(1);
    }

    @Test
    public void whenFindItemByCodeShouldReturnCorrectObject() throws Exception {
        RedeemCode code = redeemCodeRepository.findByCode("test");
        assertEquals(redeemCode, code);
    }

    @Test
    public void whenFindAllShouldReturnAll() throws Exception {
        Collection<RedeemCode> codes = redeemCodeRepository.findAll();
        assertEquals(1, codes.size());
    }
}
