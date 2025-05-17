package com.app.input;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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