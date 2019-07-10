import { Component, OnInit } from '@angular/core';
import { Loan } from 'src/models/loan.model';
import { LoanService } from '../loan.service';
import { Observable } from 'rxjs';
import { Router, ActivatedRoute, ParamMap, Params } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-loanbasic',
  templateUrl: './loanbasic.component.html',
  styleUrls: ['./loanbasic.component.scss']
})
export class LoanbasicComponent implements OnInit {
  loan:Loan;

  loanDaysTypes=[
    {viewValue:'360',value:'ThreeSixty'},
    {viewValue:'Actual',value:'Actual'}
  ]
  dueDateTypes=[
    {viewValue:'Anniversary Date',value:'ANNIVERSARY'},
    {viewValue:'Last day of the month',value:'LASTDAY'}
  ]
    
  
  constructor(
    private service:LoanService,
    private route:ActivatedRoute,
    private router:Router
    ) { }
 
  generateSchedules(){
    this.service.generateSchedules(this.loan).subscribe((loan:Loan) => this.loan=loan)
  }
  saveLoan(){
    this.service.saveLoan(this.loan).subscribe((loan:Loan)=>this.loan=loan);
  }
  validateLoan(){
    return this.loan.firstInstallmentDate && this.loan.dueDateType && this.loan.loanDaysType && this.loan.LoanAmount && this.loan.Interest
  }
  newLoan(){
    this.loan=new Loan();
  }
  ngOnInit() {
    //this.route.paramMap.pipe(switchMap((params:ParamMap)=>console.log(params.get('id')))
    console.log(this.route.params);
    this.loan=new Loan();
    this.route.paramMap.subscribe((params:Params)=>{
      this.service.getLoan(params.get('id')).subscribe((response:Loan)=>this.loan=response)
    });
  }

}
