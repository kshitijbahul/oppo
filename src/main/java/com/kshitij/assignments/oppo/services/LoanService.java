package com.kshitij.assignments.oppo.services;

import com.kshitij.assignments.oppo.entities.Loan;

public interface LoanService {
    Loan createLoan(Loan loan);

    Loan getLoanDetails(Long loanId);

    Iterable<Loan> getAllLoans();

    void generateLoanSchedules(Loan loan);

}
