import { NgModule } from '@angular/core';
import { Routes, ActivatedRoute,RouterModule } from '@angular/router';
import { LoanlistComponent } from './loanlist/loanlist.component';
import { LoanbasicComponent } from './loanbasic/loanbasic.component';

const appRoutes:Routes =[
  {path:'loans',component:LoanlistComponent},
  {path:'loan/:id',component:LoanbasicComponent},
  {path:'new/loan',redirectTo:'/loan/1',pathMatch:'full'},
  {path:'',redirectTo:'/loans',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
