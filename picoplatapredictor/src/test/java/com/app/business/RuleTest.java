package com.app.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    private Schedule mockSchedule;
    private Rule rule;

    @BeforeEach
    void setUp() {
        mockSchedule = Mockito.mock(Schedule.class);
        List<DayOfWeek> days = Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY);
        List<Integer> digits = Arrays.asList(1, 2, 3);
        List<Schedule> schedules = Collections.singletonList(mockSchedule);
        rule = new Rule(days, digits, schedules);
    }

    @Test
    void testIsRestricted_AllConditionsMet_ReturnsTrue() {
        Mockito.when(mockSchedule.contains(Mockito.any(LocalTime.class))).thenReturn(true);
        boolean result = rule.isRestricted(DayOfWeek.MONDAY, 2, LocalTime.of(8, 0));
        assertTrue(result);
    }

    @Test
    void testIsRestricted_DayNotRestricted_ReturnsFalse() {
        Mockito.when(mockSchedule.contains(Mockito.any(LocalTime.class))).thenReturn(true);
        boolean result = rule.isRestricted(DayOfWeek.FRIDAY, 2, LocalTime.of(8, 0));
        assertFalse(result);
    }

    @Test
    void testIsRestricted_DigitNotRestricted_ReturnsFalse() {
        Mockito.when(mockSchedule.contains(Mockito.any(LocalTime.class))).thenReturn(true);
        boolean result = rule.isRestricted(DayOfWeek.MONDAY, 9, LocalTime.of(8, 0));
        assertFalse(result);
    }

    @Test
    void testIsRestricted_TimeNotInSchedule_ReturnsFalse() {
        Mockito.when(mockSchedule.contains(Mockito.any(LocalTime.class))).thenReturn(false);
        boolean result = rule.isRestricted(DayOfWeek.MONDAY, 2, LocalTime.of(23, 0));
        assertFalse(result);
    }

    @Test
    void testGetDaysOfWeek() {
        List<DayOfWeek> days = rule.getDaysOfWeek();
        assertTrue(days.contains(DayOfWeek.MONDAY));
        assertTrue(days.contains(DayOfWeek.WEDNESDAY));
    }

    @Test
    void testGetRestrictedDigits() {
        List<Integer> digits = rule.getRestrictedDigits();
        assertTrue(digits.contains(1));
        assertTrue(digits.contains(2));
        assertTrue(digits.contains(3));
    }

    @Test
    void testIsRestricted_MultipleSchedules_OneMatches_ReturnsTrue() {
        Schedule schedule1 = Mockito.mock(Schedule.class);
        Schedule schedule2 = Mockito.mock(Schedule.class);
        Mockito.when(schedule1.contains(Mockito.any(LocalTime.class))).thenReturn(false);
        Mockito.when(schedule2.contains(Mockito.any(LocalTime.class))).thenReturn(true);

        List<Schedule> schedules = Arrays.asList(schedule1, schedule2);
        Rule multiScheduleRule = new Rule(Arrays.asList(DayOfWeek.MONDAY), Arrays.asList(1), schedules);

        boolean result = multiScheduleRule.isRestricted(DayOfWeek.MONDAY, 1, LocalTime.of(9, 0));
        assertTrue(result);
    }

    @Test
    void testIsRestricted_MultipleSchedules_NoneMatch_ReturnsFalse() {
        Schedule schedule1 = Mockito.mock(Schedule.class);
        Schedule schedule2 = Mockito.mock(Schedule.class);
        Mockito.when(schedule1.contains(Mockito.any(LocalTime.class))).thenReturn(false);
        Mockito.when(schedule2.contains(Mockito.any(LocalTime.class))).thenReturn(false);

        List<Schedule> schedules = Arrays.asList(schedule1, schedule2);
        Rule multiScheduleRule = new Rule(Arrays.asList(DayOfWeek.MONDAY), Arrays.asList(1), schedules);

        boolean result = multiScheduleRule.isRestricted(DayOfWeek.MONDAY, 1, LocalTime.of(22, 0));
        assertFalse(result);
    }

    @Test
    void testIsRestricted_EmptySchedules_ReturnsFalse() {
        Rule emptyScheduleRule = new Rule(Arrays.asList(DayOfWeek.MONDAY), Arrays.asList(1), Collections.emptyList());
        boolean result = emptyScheduleRule.isRestricted(DayOfWeek.MONDAY, 1, LocalTime.of(8, 0));
        assertFalse(result);
    }

    @Test
    void testIsRestricted_EmptyDaysOfWeek_ReturnsFalse() {
        Rule emptyDaysRule = new Rule(Collections.emptyList(), Arrays.asList(1), Collections.singletonList(mockSchedule));
        Mockito.when(mockSchedule.contains(Mockito.any(LocalTime.class))).thenReturn(true);
        boolean result = emptyDaysRule.isRestricted(DayOfWeek.MONDAY, 1, LocalTime.of(8, 0));
        assertFalse(result);
    }

    @Test
    void testIsRestricted_EmptyRestrictedDigits_ReturnsFalse() {
        Rule emptyDigitsRule = new Rule(Arrays.asList(DayOfWeek.MONDAY), Collections.emptyList(), Collections.singletonList(mockSchedule));
        Mockito.when(mockSchedule.contains(Mockito.any(LocalTime.class))).thenReturn(true);
        boolean result = emptyDigitsRule.isRestricted(DayOfWeek.MONDAY, 1, LocalTime.of(8, 0));
        assertFalse(result);
    }
}