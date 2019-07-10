import { Component, OnInit } from '@angular/core';
import { LoanService } from './loan.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'Loan Application';
  constructor(private service:LoanService){}
  ngOnInit() {
    this.service.createFirstLoan().subscribe();
  }
}
