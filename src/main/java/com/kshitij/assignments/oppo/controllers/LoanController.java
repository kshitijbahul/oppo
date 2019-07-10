package com.kshitij.assignments.oppo.controllers;

import com.kshitij.assignments.oppo.entities.Loan;
import com.kshitij.assignments.oppo.exceptions.LoanNotFoundException;
import com.kshitij.assignments.oppo.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping("/loan/{id}")
    private Loan getLoan(@PathVariable("id") Long loanId){
        return loanService.getLoanDetails(loanId);
    }
    @PostMapping("/loan")
    private ResponseEntity<Loan> createLoan(@RequestBody Loan loan){
        loanService.createLoan(loan);
        return ResponseEntity.ok(loan);
    }
    @GetMapping("/loans")
    private ResponseEntity<Iterable> getLoans(){
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @PostMapping("/loan/generateSchedules")
    private ResponseEntity<Loan>  generateLoanSchedules(@RequestBody Loan loan){
        loanService.generateLoanSchedules(loan);
        return ResponseEntity.ok(loan);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void loanNotFoundHandler(LoanNotFoundException ex){}

}
