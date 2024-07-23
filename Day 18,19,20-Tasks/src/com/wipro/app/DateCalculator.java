package com.wipro.app;

import com.wipro.model.DateRange;
import com.wipro.service.DateService;

import java.time.LocalDate;
import java.util.Scanner;

public class DateCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter start date (yyyy-MM-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.next());

        System.out.print("Enter end date (yyyy-MM-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.next());

        DateRange dateRange = new DateRange(startDate, endDate);

        long daysBetween = DateService.calculateDaysBetween(dateRange);
        System.out.println("Number of days between " + startDate + " and " + endDate + " is: " + daysBetween);

        scanner.close();
    }
}
