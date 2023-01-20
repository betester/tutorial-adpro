package id.ac.ui.cs.advprog.tutorial1.tracking.controller;

import id.ac.ui.cs.advprog.tutorial1.tracking.controller.TrackingController;
import id.ac.ui.cs.advprog.tutorial1.tracking.service.TrackingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = TrackingController.class)
public class TrackingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrackingService trackingService;

    @Test
    public void testWhenHomeCalledWithoutInputtingParameterReturn200() throws Exception{
        mockMvc.perform(get("/tracking"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("roadUsers", hasSize(0)));
    }

    @Test
    public void testWhenHandleNewDragoCalledReturnRedirect() throws Exception{
        mockMvc.perform(post("/tracking/new-drago-location")
                .param("dragoLocation", "Shefburg Path"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tracking"));
    }

    @Test
    public void testWhenHandleNewSweetsCalledReturnRedirect() throws Exception{

        mockMvc.perform(post("/tracking/new-sweets-location")
                        .param("sweetsLocation", "Shefburg Path"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tracking"));
    }

}
