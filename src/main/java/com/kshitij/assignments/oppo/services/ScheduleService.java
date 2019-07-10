package com.kshitij.assignments.oppo.services;

import com.kshitij.assignments.oppo.entities.Loan;
import com.kshitij.assignments.oppo.entities.Schedule;

public interface ScheduleService {

     Schedule getSchedule(Loan loan);
     void setFirstSchedule(Loan loan);
     Schedule setNextSchedule(Loan loan);
}
