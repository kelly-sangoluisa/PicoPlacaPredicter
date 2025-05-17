package com.app.business;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

/**
 * The {@code Rule} class represents a restriction rule for vehicle circulation.
 * Each rule specifies the days of the week, the restricted license plate digits,
 * and the time schedules during which the restriction applies.
 * <p>
 * This class provides methods to check if a given day, digit, and time are restricted
 * according to the rule.
 * </p>
 * 
 * Example usage:
 * <pre>
 *     Rule rule = new Rule(daysOfWeek, restrictedDigits, schedules);
 *     boolean isRestricted = rule.isRestricted(DayOfWeek.MONDAY, 1, LocalTime.of(8, 0));
 * </pre>
 * 
 * @author Kelly Sangoluisa
 */
public class Rule {
    private List<DayOfWeek> daysOfWeek;
    private final List<Integer> restrictedDigits;
    private final List<Schedule> schedules;

    /**
     * Constructs a new Rule with the specified days, restricted digits, and schedules.
     *
     * @param daysOfWeek the days of the week when the rule applies
     * @param restrictedDigits the list of restricted license plate digits
     * @param schedules the list of time schedules for the restriction
     */
    public Rule(List<DayOfWeek> daysOfWeek, List<Integer> restrictedDigits, List<Schedule> schedules) {
        this.daysOfWeek = daysOfWeek;
        this.restrictedDigits = restrictedDigits;
        this.schedules = schedules;
    }

    /**
     * Returns the list of days of the week when the rule applies.
     *
     * @return the list of {@link DayOfWeek}
     */
    public List<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    /**
     * Returns the list of restricted license plate digits.
     *
     * @return the list of restricted digits
     */
    public List<Integer> getRestrictedDigits() {
        return restrictedDigits;
    }

    /**
     * Checks if the given day, digit, and time are restricted according to this rule.
     *
     * @param dayOfWeek the day of the week to check
     * @param digit the last digit of the license plate to check
     * @param time the time to check
     * @return {@code true} if the combination is restricted, {@code false} otherwise
     */
    public boolean isRestricted(DayOfWeek dayOfWeek, int digit, LocalTime time) {
       for (Schedule schedule : schedules) {
            if (daysOfWeek.contains(dayOfWeek) && restrictedDigits.contains(digit) && schedule.contains(time)) {
                return true;
            }
        }
        return false;
    }
}