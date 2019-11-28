package com.kshitij.assignments.oppo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kshitij.assignments.oppo.enums.DueDateTypeEnum;
import com.kshitij.assignments.oppo.enums.LoanDaysTypeEnum;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Loan {

    @Id
    @GeneratedValue
    @JsonProperty("LoanId")
    private Long loanId;

    @JsonProperty("LoanAmount")
    private Float loanAmount;
    @JsonProperty("Interest")
    private Float interest;
    @JsonProperty("Tenure")
    private Integer tenure;
    private LocalDate firstInstallmentDate;
    private DueDateTypeEnum dueDateType;
    private Float discountingFactor;
    private LoanDaysTypeEnum loanDaysType;
    private Float eachEmi;
    @OneToMany()
    @JsonProperty("Schedules")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Schedule> schedules;
    public Loan(){

    }

    public Loan(Float loanAmount,Float interestRate,Integer tenure) {
        this.loanAmount =loanAmount;
        this.interest=interestRate;
        this.tenure = tenure;
        schedules=new ArrayList<>(tenure);
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public LoanDaysTypeEnum getLoanDaysType() {
        return loanDaysType;
    }

    public void setLoanDaysType(LoanDaysTypeEnum loanDaysType) {
        this.loanDaysType = loanDaysType;
    }

    public Float getEachEmi() {
        return eachEmi;
    }

    public void setEachEmi(Float eachEmi) {
        this.eachEmi = eachEmi;
    }

    public Float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public LocalDate getFirstInstallmentDate() {
        return firstInstallmentDate;
    }

    public void setFirstInstallmentDate(LocalDate firstInstallmentDate) {
        this.firstInstallmentDate = firstInstallmentDate;
    }

    public List<Schedule> getSchedules() {
        schedules = schedules==null ?  new ArrayList<>(tenure): schedules;
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Float getDiscountingFactor() {
        return discountingFactor;
    }

    public void setDiscountingFactor(Float discountingFactor) {
        this.discountingFactor = discountingFactor;
    }

    public DueDateTypeEnum getDueDateType() {
        return dueDateType;
    }

    public void setDueDateType(DueDateTypeEnum dueDateType) {
        this.dueDateType = dueDateType;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanAmount=" + loanAmount +
                ", interest=" + interest +
                ", tenure=" + tenure +
                ", firstInstallmentDate=" + firstInstallmentDate +
                ", dueDateType=" + dueDateType +
                ", discountingFactor=" + discountingFactor +
                ", loanDaysType=" + loanDaysType +
                ", eachEmi=" + eachEmi +
                ", schedules=" + schedules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(loanId, loan.loanId) &&
                Objects.equals(loanAmount, loan.loanAmount) &&
                Objects.equals(interest, loan.interest) &&
                Objects.equals(tenure, loan.tenure) &&
                Objects.equals(firstInstallmentDate, loan.firstInstallmentDate) &&
                dueDateType == loan.dueDateType &&
                Objects.equals(discountingFactor, loan.discountingFactor) &&
                loanDaysType == loan.loanDaysType &&
                Objects.equals(eachEmi, loan.eachEmi) &&
                Objects.equals(schedules, loan.schedules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanAmount, interest, tenure, firstInstallmentDate, dueDateType, discountingFactor, loanDaysType, eachEmi, schedules);
    }
}
