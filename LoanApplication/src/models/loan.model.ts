import { Schedule } from './schedule.model';

export class Loan{
    firstInstallmentDate:Date;
    dueDateType:String;
    discountingFactor:Number;
    loanDaysType:String;
    eachEmi:Number;
    LoanId:Number;
    LoanAmount:Number;
    Interest:Number;
    Tenure:Number;
    Schedules:Schedule[];
}