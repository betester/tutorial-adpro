package id.ac.ui.cs.adpro.tutorial3.automata.core.adapter;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Punchable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GolemAdapterTest {
    @Spy
    final private Golem golem = mock(Golem.class);
    final private GolemAdapter golemAdapter = new GolemAdapter(golem);
    List<String> mockInventory;
    String any;

    @BeforeEach
    public void setUp() throws Exception {
        mockInventory = new ArrayList<>();
        any = "any";
        mockInventory.add("any");
        mockInventory.add("any1");
        mockInventory.add("any");
        mockInventory.add("any2");
    }

    @Test
    public void shouldCallLiftItemWhenLiftItemFromAdapterIsCalled() {
        golemAdapter.liftItem(any);
        verify(golem, times(1)).liftItem(any);
    }

    @Test
    public void shouldCallIsItemAsManyAsTheSizeOfTheInventory() {
        when(golem.isItem(anyString(),anyString())).thenAnswer(i -> String.format("item %s is %s",i.getArguments()[0],i.getArguments()[1]));
        golemAdapter.countItem(mockInventory,any);
        verify(golem,times(4)).isItem(anyString(),anyString());
    }

    @Test
    public void shouldReturnTheCorrectNumberOfSameItemInInventory() {
        when(golem.getName()).thenReturn("mockGolem");
        when(golem.isItem(anyString(),anyString())).thenAnswer(i -> String.format("item %s is %s",i.getArguments()[0],i.getArguments()[1]));
        String output = golemAdapter.countItem(mockInventory,any);
        String expectedOutput = "mockGolem founds 2 any in inventory";
        assertEquals(expectedOutput,output);
    }
    @Test
    public void shouldCallTossTransporterWhenUseTransporterIsCalled() {
        golemAdapter.useTransporter();
        verify(golem,times(1)).toss("transporter");
    }

    @Test
    public void shouldPunchCraneLeverWhenUseCraneIsCalled() {
        golemAdapter.useCrane();
        verify(golem,times(1)).punch(Punchable.CraneLever);
    }

}
