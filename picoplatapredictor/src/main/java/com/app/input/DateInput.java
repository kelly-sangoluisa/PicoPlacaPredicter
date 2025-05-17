package com.app.input;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateInput {
    private String rawDate;
   
    public DateInput(String rawDate) {
        this.rawDate = rawDate;
    }
    
    public LocalDate parseDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(this.rawDate, formatter);
    }

    public DayOfWeek getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek();
    }

}