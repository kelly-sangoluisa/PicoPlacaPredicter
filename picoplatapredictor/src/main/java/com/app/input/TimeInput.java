package com.app.input;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * The {@code TimeInput} class is responsible for handling and parsing time input from the user.
 * It provides a method to parse a time string into a {@link LocalTime} object.
 * <p>
 * The expected time format is "HH:mm".
 * </p>
 *
 * Example usage:
 * <pre>
 *     TimeInput timeInput = new TimeInput("08:30");
 *     LocalTime time = timeInput.parseTime();
 * </pre>
 *
 * @author Kelly Sangoluisa
 */
public class TimeInput {
    private String rawTime;

    public TimeInput(String rawTime) {
        this.rawTime = rawTime;
    }

    public LocalTime parseTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(this.rawTime, formatter);
    }
}