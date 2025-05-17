package com.app.input;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateInput {
    private String rawDate;
   
    public DateInput(String rawDate) {
        this.rawDate = rawDate;
    }
    
    public LocalDate parseDate() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(rawDate, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date: " + rawDate, e);
        }
    }

    public DayOfWeek getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek();
    }

}