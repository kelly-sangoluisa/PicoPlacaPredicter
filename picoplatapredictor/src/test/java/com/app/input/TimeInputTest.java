package com.app.input;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class TimeInputTest {

    @Test
    void parseTime_validTime_returnsLocalTime() {
        TimeInput input = new TimeInput("14:30");
        LocalTime expected = LocalTime.of(14, 30);
        assertEquals(expected, input.parseTime());
    }

    @Test
    void parseTime_midnight_returnsLocalTime() {
        TimeInput input = new TimeInput("00:00");
        LocalTime expected = LocalTime.of(0, 0);
        assertEquals(expected, input.parseTime());
    }

    @Test
    void parseTime_invalidFormat_throwsException() {
        TimeInput input = new TimeInput("2:30 PM");
        assertThrows(Exception.class, input::parseTime);
    }

    @Test
    void parseTime_nullInput_throwsException() {
        TimeInput input = new TimeInput(null);
        assertThrows(Exception.class, input::parseTime);
    }

    @Test
    void parseTime_invalidNumbers_throwsException() {
        TimeInput input = new TimeInput("25:61");
        assertThrows(Exception.class, input::parseTime);
    }
}