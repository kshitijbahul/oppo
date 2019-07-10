package com.kshitij.assignments.oppo.services;

import com.kshitij.assignments.oppo.entities.Loan;
import com.kshitij.assignments.oppo.entities.Schedule;
import com.kshitij.assignments.oppo.enums.DueDateTypeEnum;
import com.kshitij.assignments.oppo.enums.LoanDaysTypeEnum;
import com.kshitij.assignments.oppo.repository.LoanRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
@RunWith(MockitoJUnitRunner.class)

public class LoanServiceTest {

    @Mock
    LoanRepository loanRepository;


    ScheduleService scheduleService;

    private LoanService loanService;


    @Before
    public void preSetUp(){
        scheduleService=new ScheduleServiceImpl();
        loanService=new LoanServiceImpl(loanRepository,scheduleService);
    }

    @Test
    public void getLoan_ShouldReturnLoan(){

    }

    @Test
    public void checkSchedulesInALoan(){
        Loan loan=new Loan(100000F,0.10F,24);
        loan.setDueDateType(DueDateTypeEnum.ANNIVERSARY);
        loan.setFirstInstallmentDate(LocalDate.now());
        loan.setLoanDaysType(LoanDaysTypeEnum.Actual);
        loanService.createLoan(loan);
        System.out.println(loan);
        Float principalCount=0F,collected=0F;
        for (Schedule schedule:loan.getSchedules()){
            principalCount+=schedule.getPrincipal()==null ? 0 : schedule.getPrincipal();
            collected+=schedule.getEmi()==null ?0:schedule.getEmi();
        }
        assertThat(loan.getSchedules(),hasSize(loan.getTenure()+1));
        assertThat(collected,greaterThan(loan.getLoanAmount()));
        assertThat(principalCount,lessThanOrEqualTo(loan.getLoanAmount()));
    }


}