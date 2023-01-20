package id.ac.ui.cs.advprog.tutorial4.core.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RedeemCodeUtilTest {

    @Test
    public void testGetGenerateCodeWorksCorrectly() throws Exception {
        String code = RedeemCodeUtil.generateCode();

        assertEquals(String.class, code.getClass());
        assertEquals(18, code.length());
    }
}
