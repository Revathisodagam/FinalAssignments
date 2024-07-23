package com.wipro.service;

import com.wipro.model.DateRange;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateService {

    public static long calculateDaysBetween(DateRange dateRange) {
        LocalDate startDate = dateRange.getStartDate();
        LocalDate endDate = dateRange.getEndDate();

        // Calculate days between two dates
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
}
