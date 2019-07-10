import { Component, OnInit } from '@angular/core';
import { LoanService } from '../loan.service';
import { Loan } from 'src/models/loan.model';

@Component({
  selector: 'app-loanlist',
  templateUrl: './loanlist.component.html',
  styleUrls: ['./loanlist.component.scss']
})
export class LoanlistComponent implements OnInit {
  loans:Loan[];
  displayedColumns = ['Load Id','Tenure','Interest','Each Emi','Due date','Loan Days'];
  constructor(service:LoanService){
      service.getLoans().subscribe((data:Loan[])=> this.loans=data
      );
  }
  
  ngOnInit() {
  }

}
