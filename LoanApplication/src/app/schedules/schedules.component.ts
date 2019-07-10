import { Component, OnInit, Input } from '@angular/core';
import { LoanService } from '../loan.service';
import { Loan } from 'src/models/loan.model';
import { Schedule } from 'src/models/schedule.model';

@Component({
  selector: 'app-schedules',
  templateUrl: './schedules.component.html',
  styleUrls: ['./schedules.component.scss']
})
export class SchedulesComponent implements OnInit {
  @Input() schedules:Schedule[];
  displayedColumns = ['scheduleNumber','dueDate','emi','principal','interest','principalOutstanding','daysInMonth','daysInYear'];
    constructor(private service:LoanService){
        
    }

  ngOnInit() {
    
  }

}
