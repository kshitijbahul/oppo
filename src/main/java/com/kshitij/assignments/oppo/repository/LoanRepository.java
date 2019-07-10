package com.kshitij.assignments.oppo.repository;

import com.kshitij.assignments.oppo.entities.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan,Long> {

}
