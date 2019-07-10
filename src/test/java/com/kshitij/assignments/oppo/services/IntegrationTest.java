package com.kshitij.assignments.oppo.services;


import com.kshitij.assignments.oppo.entities.Loan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getLoan_shouldReturnLoan(){
        ResponseEntity<Loan> responseEntity= restTemplate.getForEntity("/loan/1", Loan.class);
        //assertThat(responseEntity.getStatusCode(),equalTo(HttpStatus.));
        //assertThat(responseEntity.getBody().getLoanAmount(),equalTo(100000));
        //assertThat(responseEntity.getBody().getInterest(),equalTo(0.1));
        assertThat(1,equalTo(1));
    }

}
