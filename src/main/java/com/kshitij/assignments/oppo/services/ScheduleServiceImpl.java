package com.kshitij.assignments.oppo.services;

import com.kshitij.assignments.oppo.entities.Loan;
import com.kshitij.assignments.oppo.entities.Schedule;
import com.kshitij.assignments.oppo.enums.DueDateTypeEnum;
import com.kshitij.assignments.oppo.enums.LoanDaysTypeEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
@Service
public class ScheduleServiceImpl implements ScheduleService{


    public Schedule getSchedule(Loan loan) {
        return null;
    }

    private LocalDate getScheduleDueDate(DueDateTypeEnum dueDateType,LocalDate lastDueDate){
       return  dueDateType.equals(DueDateTypeEnum.ANNIVERSARY)?
                lastDueDate.plusMonths(1):lastDueDate.plusMonths(1).with(lastDayOfMonth());
    }
    public Schedule setNextSchedule(Loan loan) {
        Schedule schedule=new Schedule();
        Schedule prevSchedule=loan.getSchedules().get(loan.getSchedules().size()-1);
        schedule.setScheduleNumber(loan.getSchedules().size());
        schedule.setDueDate(getScheduleDueDate(loan.getDueDateType(),prevSchedule.getDueDate()));
        schedule.setEmi(loan.getEachEmi());
        schedule.setDaysInMonth(schedule.getDueDate().lengthOfMonth());
        schedule.setDaysInYear(getDaysOfTheYear(loan.getLoanDaysType(),schedule.getDueDate().lengthOfYear()));
        schedule.setInterest(prevSchedule.getPrincipalOutstanding()*(loan.getInterest()/100)*(Float.valueOf(schedule.getDaysInMonth())/Float.valueOf(schedule.getDaysInYear())));
        schedule.setPrincipalOutstanding(prevSchedule.getPrincipalOutstanding()-schedule.getPrincipal());
        if (schedule.getScheduleNumber().equals(loan.getTenure())){
            System.out.println("Saw the last tenure "+schedule.getPrincipalOutstanding()+"schedule.getEmi() ::"+schedule.getEmi());
            schedule.setEmi(schedule.getEmi()+schedule.getPrincipalOutstanding());
            schedule.setPrincipalOutstanding(0.0F);
        }
        schedule.setLoan(loan);
        return schedule;
    }

    private Integer getDaysOfTheYear(LoanDaysTypeEnum loanDaysType, int lengthOfYear) {
        return loanDaysType.equals(LoanDaysTypeEnum.ThreeSixty)? 360 : lengthOfYear;
    }

    public void setFirstSchedule(Loan loan) {


        Schedule schedule=new Schedule();
        schedule.setScheduleNumber(0);
        schedule.setEmi(0F);
        schedule.setInterest(0F);
        schedule.setDueDate(loan.getFirstInstallmentDate());
        schedule.setPrincipalOutstanding(loan.getLoanAmount());
        schedule.setLoan(loan);
        loan.getSchedules().add(schedule);


    }
}
