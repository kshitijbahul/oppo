package com.kshitij.assignments.oppo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Schedule {

    @Id
    @GeneratedValue
    private Long id;
    private Integer scheduleNumber;
    private LocalDate dueDate;
    private Float emi;
    private Float interest;
    private Float principal;
    private Float principalOutstanding;
    private Integer daysInMonth;
    private Integer daysInYear;
    private Integer actualDaysInMonth;
    private Integer actualCummulativeDays;
    private Float discountingFactor;
    @ManyToOne
    @JoinColumn(name="loanId")
    @JsonBackReference
    private Loan loan;

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScheduleNumber() {
        return scheduleNumber;
    }

    public void setScheduleNumber(Integer scheduleNumber) {
        this.scheduleNumber = scheduleNumber;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Float getEmi() {
        return emi;
    }

    public void setEmi(Float emi) {
        this.emi = emi;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
        this.setPrincipal(this.emi-this.interest);

    }

    public Float getPrincipal() {
        return principal;
    }

    public void setPrincipal(Float principal) {
        this.principal = principal;
    }

    public Float getPrincipalOutstanding() {
        return principalOutstanding;
    }

    public void setPrincipalOutstanding(Float principalOutstanding) {
        this.principalOutstanding = principalOutstanding;
    }

    public Integer getDaysInMonth() {
        return daysInMonth;
    }

    public void setDaysInMonth(Integer daysInMonth) {
        this.daysInMonth = daysInMonth;
    }

    public Integer getDaysInYear() {
        return daysInYear;
    }

    public void setDaysInYear(Integer daysInYear) {
        this.daysInYear = daysInYear;
    }

    public Integer getActualDaysInMonth() {
        return actualDaysInMonth;
    }

    public void setActualDaysInMonth(Integer actualDaysInMonth) {
        this.actualDaysInMonth = actualDaysInMonth;
    }

    public Integer getActualCummulativeDays() {
        return actualCummulativeDays;
    }

    public void setActualCummulativeDays(Integer actualCummulativeDays) {
        this.actualCummulativeDays = actualCummulativeDays;
    }

    public Float getDiscountingFactor() {
        return discountingFactor;
    }

    public void setDiscountingFactor(Float discountingFactor) {
        this.discountingFactor = discountingFactor;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleNumber=" + scheduleNumber +
                ", dueDate=" + dueDate +
                ", emi=" + emi +
                ", interest=" + interest +
                ", principal=" + principal +
                ", principalOutstanding=" + principalOutstanding +
                ", daysInMonth=" + daysInMonth +
                ", daysInYear=" + daysInYear +
                ", actualDaysInMonth=" + actualDaysInMonth +
                ", actualCummulativeDays=" + actualCummulativeDays +
                ", discountingFactor=" + discountingFactor +
                '}';
    }
}
