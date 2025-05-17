package com.app.input;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DateInputTest {

    @Test
    void testParseDate_ValidDate() {
        DateInput dateInput = new DateInput("15-06-2024");
        LocalDate expected = LocalDate.of(2024, 6, 15);
        assertEquals(expected, dateInput.parseDate());
    }

    @Test
    void testParseDate_AnotherValidDate() {
        DateInput dateInput = new DateInput("01-01-2000");
        LocalDate expected = LocalDate.of(2000, 1, 1);
        assertEquals(expected, dateInput.parseDate());
    }

    @Test
    void testParseDate_InvalidFormat() {
        DateInput dateInput = new DateInput("2024-06-15");
        assertThrows(Exception.class, dateInput::parseDate);
    }
}