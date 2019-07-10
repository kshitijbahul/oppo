import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoanService } from './loan.service';
import { HttpClientModule } from '@angular/common/http';
import { SchedulesComponent } from './schedules/schedules.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule,MatInputModule,MatSelectModule} from '@angular/material';
import {MatButtonModule} from '@angular/material/button';
import { LoanbasicComponent } from './loanbasic/loanbasic.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoanlistComponent } from './loanlist/loanlist.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatMenuModule} from '@angular/material/menu';




@NgModule({
  declarations: [
    AppComponent,
    SchedulesComponent,
    LoanbasicComponent,
    LoanlistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatSidenavModule,
    MatMenuModule
  ],
  providers: [LoanService],
  bootstrap: [AppComponent]
})
export class AppModule { }
