import { NgModule } from '@angular/core';
import { Routes, ActivatedRoute,RouterModule } from '@angular/router';
import { LoanlistComponent } from './loanlist/loanlist.component';
import { LoanbasicComponent } from './loanbasic/loanbasic.component';

const appRoutes:Routes =[
  {path:'loanapplication/loans',component:LoanlistComponent},
  {path:'loanapplication/loan/:id',component:LoanbasicComponent},
  {path:'new/loan',redirectTo:'/loan/0',pathMatch:'full'},
  {path:'',redirectTo:'/loanapplication/loans',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
