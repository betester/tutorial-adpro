package id.ac.ui.cs.adpro.tutorial3.automata.core.adapter;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Direction;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FluidAdapterTest {
    final private Fluids fluid = mock(Fluids.class);
    final private FluidAdapter fluidAdapter = new FluidAdapter(fluid);
    List<String> mockInventory;
    String any;

    @BeforeEach
    public void setUp() throws Exception {
        mockInventory = new ArrayList<>();
        any = "any";
    }

    @Test
    public void shouldCallPushItemWithDirectionUpWhenLiftItemIsCalled() {
        fluidAdapter.liftItem(any);
        verify(fluid, times(1)).pushItem(any, Direction.Up);
    }
    @Test
    public void shouldCallSplitWhenCountItemIsCalled() {
        fluidAdapter.countItem(mockInventory,any);
        verify(fluid,times(1)).splitBy(mockInventory,any);
    }
    @Test
    public void shouldReturnStringIntegerWhenCountItemIsCalled() {
        when(fluid.splitBy(mockInventory,any)).thenReturn("10");
        String output = fluidAdapter.countItem(mockInventory,any);
        String expectedOutput = "2";
        assertEquals(output,expectedOutput);
    }
    @Test
    public void shouldCallShapeShiftToTransporterWhenUseTransporterIsCalled() {
        fluidAdapter.useTransporter();
        verify(fluid,times(1)).shapeShift(Shape.Transporter);
    }

    @Test
    public void shouldShapeShiftToCraneWhenUseCraneIsCalled() {
        fluidAdapter.useCrane();
        verify(fluid,times(1)).shapeShift(Shape.Crane);
    }

}
