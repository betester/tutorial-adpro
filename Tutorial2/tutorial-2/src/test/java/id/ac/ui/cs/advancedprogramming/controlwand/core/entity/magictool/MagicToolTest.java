package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagicToolTest {
    private final String magicToolName = "Name";
    private MagicTool magicTool;

    @BeforeEach
    public void setUp() {
        magicTool = Mockito.mock(
                MagicTool.class,
                Mockito.withSettings().useConstructor(magicToolName)
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

    @Test
    public void whenDefineStateIsCalledItShouldReturnAStringStatingCurrentState() {
        ManaIntensity noManaIntensity = ManaIntensity.NONE;
        String expectedDefineStateOutput = magicToolName +
                "'s mana intensity has been set to " +
                noManaIntensity;
        assertEquals(expectedDefineStateOutput, magicTool.defineState(noManaIntensity));
    }

    @Test
    public void whenOffIsCalledItShouldSetManaIntensityToNone() throws Exception {
        ManaIntensity noManaIntensity = ManaIntensity.NONE;

        magicTool.off();

        assertEquals(noManaIntensity, magicTool.getCurrentState());
    }

    @Test
    public void whenLowIsCalledItShouldSetManaIntensityToLow() throws Exception {
        ManaIntensity lowManaIntensity = ManaIntensity.LOW;

        magicTool.low();

        assertEquals(lowManaIntensity, magicTool.getCurrentState());
    }

    @Test
    public void whenMediumIsCalledItShouldSetManaIntensityToMedium() throws Exception {
        ManaIntensity mediumManaIntensity = ManaIntensity.MEDIUM;

        magicTool.medium();

        assertEquals(mediumManaIntensity, magicTool.getCurrentState());
    }

    @Test
    public void whenHighIsCalledItShouldSetManaIntensityToHigh() throws Exception {
        ManaIntensity highManaIntensity = ManaIntensity.HIGH;

        magicTool.high();

        assertEquals(highManaIntensity, magicTool.getCurrentState());
    }
}
