package com.app.business;

import java.time.LocalTime;

/**
 * The {@code Schedule} class represents a time interval with a start and end time.
 * It is used to define the periods during which a restriction is active.
 * <p>
 * The class provides a method to check if a specific time falls within the schedule.
 * </p>
 *
 * Example usage:
 * <pre>
 *     Schedule schedule = new Schedule(LocalTime.of(6, 0), LocalTime.of(9, 30));
 *     boolean isWithin = schedule.contains(LocalTime.of(8, 0));
 * </pre>
 *
 * @author Kelly Sangoluisa
 */
public class Schedule {
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * Constructs a new Schedule with the specified start and end times.
     *
     * @param startTime the start time of the schedule
     * @param endTime the end time of the schedule
     */
    public Schedule(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Checks if the specified time falls within the schedule.
     *
     * @param time the time to check
     * @return {@code true} if the time is within the schedule, {@code false} otherwise
     */
    public boolean contains(LocalTime time) {
        return !time.isBefore(startTime) && !time.isAfter(endTime);
    }
}