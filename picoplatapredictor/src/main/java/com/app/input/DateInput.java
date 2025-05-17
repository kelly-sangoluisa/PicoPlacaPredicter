package com.app.input;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The {@code DateInput} class is responsible for handling and parsing date input from the user.
 * It provides methods to parse a date string into a {@link LocalDate} object and to obtain
 * the day of the week from a given date.
 * <p>
 * The expected date format is "dd-MM-yyyy".
 * </p>
 *
 * Example usage:
 * <pre>
 *     DateInput dateInput = new DateInput("17-05-2025");
 *     LocalDate date = dateInput.parseDate();
 *     DayOfWeek dayOfWeek = dateInput.getDayOfWeek(date);
 * </pre>
 *
 * @author Kelly Sangoluisa
 */
public class DateInput {
    private String rawDate;
   
    public DateInput(String rawDate) {
        this.rawDate = rawDate;
    }
    
    /**
     * Parses the raw date string into a {@link LocalDate} object using the format "dd-MM-yyyy".
     *
     * @return the parsed {@link LocalDate}
     * @throws IllegalArgumentException if the date string is invalid
     */
    public LocalDate parseDate() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(rawDate, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date: " + rawDate, e);
        }
    }

    /**
     * Returns the {@link DayOfWeek} for the given {@link LocalDate}.
     *
     * @param date the date to get the day of the week from
     * @return the {@link DayOfWeek}
     */
    public DayOfWeek getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek();
    }

}