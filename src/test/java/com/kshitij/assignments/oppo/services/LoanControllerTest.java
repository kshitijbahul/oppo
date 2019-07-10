package com.kshitij.assignments.oppo.services;

import com.kshitij.assignments.oppo.controllers.LoanController;
import com.kshitij.assignments.oppo.entities.Loan;
import com.kshitij.assignments.oppo.exceptions.LoanNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LoanController.class)
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LoanService loanService;

    @Test
    public void getLoan_shouldReturnCar() throws Exception {
        given(loanService.getLoanDetails(2L)).willReturn(new Loan(100000.0F,0.1F,24));
        mockMvc.perform(MockMvcRequestBuilders.get("/loan/1")).andExpect(status().isOk())
                .andExpect(jsonPath("LoanAmount").value(100000.00))
                .andExpect(jsonPath("Interest").value(0.1))
                .andExpect(jsonPath("Schedules").isArray());
    }

    @Test
    public  void getLoan_notFound() throws Exception {
        given(loanService.getLoanDetails(2L)).willThrow(new LoanNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/loan/2")).andExpect(status().isNotFound());
    }

}
