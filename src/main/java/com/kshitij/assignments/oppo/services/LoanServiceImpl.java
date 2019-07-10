package com.kshitij.assignments.oppo.services;

import com.kshitij.assignments.oppo.entities.Loan;
import com.kshitij.assignments.oppo.exceptions.LoanNotFoundException;
import com.kshitij.assignments.oppo.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class LoanServiceImpl implements LoanService {

    //@Autowired
    ScheduleService scheduleService;

    private LoanRepository loanRepository;

    LoanServiceImpl(LoanRepository loanRepository,ScheduleService scheduleService){
        this.loanRepository=loanRepository;
        this.scheduleService=scheduleService;
    }
    /*LoanServiceImpl(ScheduleService scheduleService){
        //this.loanRepository=loanRepository;
        this.scheduleService=scheduleService;
    }*/


    private Double getDiscountingFactor(Integer numberOfDays,Integer totalDaysSince,Float interestRate){
        /*
        System.out.println("1/Math.pow((1+interestRate/12),(totalDaysSince/numberOfDays))::" +(interestRate/12));
        System.out.println("1/Math.pow((1+interestRate/12),(totalDaysSince/numberOfDays))::" +(totalDaysSince/numberOfDays));
        System.out.println("1/Math.pow((1+interestRate/12),(totalDaysSince/numberOfDays))::" +Math.pow((1+interestRate/12),(totalDaysSince/numberOfDays)));

         */
        System.out.println("1/Math.pow((1+interestRate/12),(totalDaysSince/numberOfDays))::" +(1/Math.pow((1+interestRate/12),(totalDaysSince/numberOfDays))));
        return  1/Math.pow((1+interestRate/12),(totalDaysSince/numberOfDays));
    }
    private Float getTotalDiscountingFactor(Integer tenure, Float interestRate, LocalDate firstScheduleDate){
        Integer totalDaysSince=0;
        Float totalDiscountingFactor=0.0F;
        for(int i=1;i<=tenure;i++){
            totalDaysSince+=firstScheduleDate.plusMonths(i).lengthOfMonth();
            totalDiscountingFactor+=getDiscountingFactor(firstScheduleDate.plusMonths(i).lengthOfMonth(),totalDaysSince,interestRate).floatValue();

        }
        System.out.println("total days"+totalDaysSince+" totalDiscountingFactor::"+totalDiscountingFactor);
        return totalDiscountingFactor;
    }
    public Loan createLoan(Loan loan){
        setLoanDetails(loan);
        if (loan.getSchedules()==null || loan.getSchedules().isEmpty()){
            generateLoanSchedules(loan);
        }
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanDetails(Long loanId) {
        return loanRepository.findById(loanId).orElseThrow(LoanNotFoundException::new);
    }

    @Override
    public Iterable<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    private void setLoanDetails(Loan loan){
        loan.setDiscountingFactor(getTotalDiscountingFactor(loan.getTenure(),(loan.getInterest()/100),loan.getFirstInstallmentDate()));
        loan.setEachEmi(Double.valueOf(loan.getLoanAmount()/loan.getDiscountingFactor()).floatValue());

    }
    public void generateLoanSchedules(Loan loan){
        setLoanDetails(loan);
        if (loan.getSchedules() !=null && ! loan.getSchedules().isEmpty()){
            loan.setSchedules(new ArrayList<>(loan.getTenure()));
        }
        scheduleService.setFirstSchedule(loan);
        for(int i=0;i<loan.getTenure();i++){
            loan.getSchedules().add(scheduleService.setNextSchedule(loan));
        }

    }
}
