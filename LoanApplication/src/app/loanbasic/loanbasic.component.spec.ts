import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanbasicComponent } from './loanbasic.component';

describe('LoanbasicComponent', () => {
  let component: LoanbasicComponent;
  let fixture: ComponentFixture<LoanbasicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoanbasicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanbasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
