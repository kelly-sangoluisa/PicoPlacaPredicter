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
        DateInput dateInput = new DateInput("2024-06-12");
        TimeInput timeInput = new TimeInput("09:15");
        LicensePlate plate = new LicensePlate("DEF-4321");

        predictor.setDate(dateInput);
        predictor.setTime(timeInput);
        predictor.setPlate(plate);

        // No assertion needed, just ensure no exceptions are thrown
    }
}