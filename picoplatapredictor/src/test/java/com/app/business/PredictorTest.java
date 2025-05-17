package com.app.business;
import com.app.input.DateInput;
import com.app.input.LicensePlate;
import com.app.input.TimeInput;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class PredictorTest {

    private RuleSet ruleSet;
    private Predictor predictor;

    @BeforeEach
    void setUp() {
        ruleSet = mock(RuleSet.class);
        predictor = new Predictor(ruleSet);
    }

    

    @Test
    void testSetters() {
        DateInput dateInput = new DateInput("12-06-2024");
        TimeInput timeInput = new TimeInput("09:15");
        LicensePlate plate = new LicensePlate("DEF-4321");

        predictor.setDate(dateInput);
        predictor.setTime(timeInput);
        predictor.setPlate(plate);

        // No assertion needed, just ensure no exceptions are thrown
    }

    @Test
    void testPredictReturnsTrueWhenRestrictionApplies() {
        // Arrange
        String rawDate = "10-06-2024"; // Monday
        String rawTime = "08:00";
        String fullPlate = "ABC-1234";
        DayOfWeek expectedDay = DayOfWeek.MONDAY;
        int expectedLastDigit = 4;
        LocalTime expectedTime = LocalTime.of(8, 0);

        when(ruleSet.hasRestriction(eq(expectedDay), eq(expectedLastDigit), eq(expectedTime))).thenReturn(true);

        // Act
        boolean result = predictor.predict(rawDate, rawTime, fullPlate);

        // Assert
        assertTrue(result);
        verify(ruleSet).hasRestriction(eq(expectedDay), eq(expectedLastDigit), eq(expectedTime));
    }

    @Test
    void testPredictReturnsFalseWhenNoRestriction() {
        // Arrange
        String rawDate = "11-06-2024"; // Tuesday
        String rawTime = "15:30";
        String fullPlate = "XYZ-5678";
        DayOfWeek expectedDay = DayOfWeek.TUESDAY;
        int expectedLastDigit = 8;
        LocalTime expectedTime = LocalTime.of(15, 30);

        when(ruleSet.hasRestriction(eq(expectedDay), eq(expectedLastDigit), eq(expectedTime))).thenReturn(false);

        // Act
        boolean result = predictor.predict(rawDate, rawTime, fullPlate);

        // Assert
        assertFalse(result);
        verify(ruleSet).hasRestriction(eq(expectedDay), eq(expectedLastDigit), eq(expectedTime));
    }

    @Test
    void testPredictWithDifferentPlateFormats() {
        // Arrange
        String rawDate = "12-06-2024"; // Wednesday
        String rawTime = "10:45";
        String fullPlate = "1234";
        DayOfWeek expectedDay = DayOfWeek.WEDNESDAY;
        int expectedLastDigit = 4;
        LocalTime expectedTime = LocalTime.of(10, 45);

        when(ruleSet.hasRestriction(eq(expectedDay), eq(expectedLastDigit), eq(expectedTime))).thenReturn(true);

        // Act
        boolean result = predictor.predict(rawDate, rawTime, fullPlate);

        // Assert
        assertTrue(result);
        verify(ruleSet).hasRestriction(eq(expectedDay), eq(expectedLastDigit), eq(expectedTime));
    }

    @Test
    void testPredictThrowsExceptionForInvalidDate() {
        assertThrows(Exception.class, () -> {
            predictor.predict("invalid-date", "08:00", "ABC-1234");
        });
    }

    @Test
    void testPredictThrowsExceptionForInvalidTime() {
        assertThrows(Exception.class, () -> {
            predictor.predict("10-06-2024", "invalid-time", "ABC-1234");
        });
    }
}