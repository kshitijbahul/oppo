import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Loan } from 'src/models/loan.model';

//const apiEndPoint = `http://localhost:3002/`;
const apiEndPoint = `/`;
const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
};
const date :Date = new Date();
const defaultLoan = {
    "firstInstallmentDate": "2019-07-17",
    "dueDateType": "ANNIVERSARY",
    "loanDaysType": "ThreeSixty",
    "LoanAmount": 110000,
    "Interest": 10,
    "Tenure": 25
};

@Injectable()
export class LoanService{
    constructor(private http:HttpClient){}
    getLoans():Observable<Loan[]>{
        return this.http.get<Loan[]>(apiEndPoint+'loans').pipe();
    }
    getLoan(loanId:Number):Observable<Loan>{
        return this.http.get<Loan>(apiEndPoint+'loan/'+loanId).pipe();
    }
    generateSchedules(loan:Loan):Observable<Loan>{
        return this.http.post<Loan>(apiEndPoint+'loan/generateSchedules',loan,httpOptions).pipe();
    }
    saveLoan(loan:Loan):Observable<Loan>{
        return this.http.post<Loan>(apiEndPoint+'loan',loan,httpOptions).pipe();
    }
    createFirstLoan():Observable<any>{
        return this.http.post(apiEndPoint+'loan',defaultLoan,httpOptions).pipe();
    }
}