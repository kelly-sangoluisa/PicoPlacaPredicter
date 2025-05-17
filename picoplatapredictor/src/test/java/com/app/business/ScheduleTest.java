package com.app.business;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @Test
    void testContains_TimeWithinRange() {
        Schedule schedule = new Schedule(LocalTime.of(7, 0), LocalTime.of(9, 30));
        assertTrue(schedule.contains(LocalTime.of(8, 0)));
    }

    @Test
    void testContains_TimeEqualsStartTime() {
        Schedule schedule = new Schedule(LocalTime.of(7, 0), LocalTime.of(9, 30));
        assertTrue(schedule.contains(LocalTime.of(7, 0)));
    }

    @Test
    void testContains_TimeEqualsEndTime() {
        Schedule schedule = new Schedule(LocalTime.of(7, 0), LocalTime.of(9, 30));
        assertTrue(schedule.contains(LocalTime.of(9, 30)));
    }

    @Test
    void testContains_TimeBeforeStartTime() {
        Schedule schedule = new Schedule(LocalTime.of(7, 0), LocalTime.of(9, 30));
        assertFalse(schedule.contains(LocalTime.of(6, 59)));
    }

    @Test
    void testContains_TimeAfterEndTime() {
        Schedule schedule = new Schedule(LocalTime.of(7, 0), LocalTime.of(9, 30));
        assertFalse(schedule.contains(LocalTime.of(9, 31)));
    }

    @Test
    void testContains_StartTimeEqualsEndTime() {
        Schedule schedule = new Schedule(LocalTime.of(8, 0), LocalTime.of(8, 0));
        assertTrue(schedule.contains(LocalTime.of(8, 0)));
        assertFalse(schedule.contains(LocalTime.of(7, 59)));
        assertFalse(schedule.contains(LocalTime.of(8, 1)));
    }
}