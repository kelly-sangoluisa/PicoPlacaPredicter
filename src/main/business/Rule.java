package business;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class Rule {
    private List<DayOfWeek> daysOfWeek;
    private final List<Integer> restrictedDigits;
    private final List<Schedule> schedules;

    public Rule(List<DayOfWeek> daysOfWeek, List<Integer> restrictedDigits, List<Schedule> schedules) {
        this.daysOfWeek = daysOfWeek;
        this.restrictedDigits = restrictedDigits;
        this.schedules = schedules;
    }

    public List<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public List<Integer> getRestrictedDigits() {
        return restrictedDigits;
    }

    public boolean isRestricted(DayOfWeek dayOfWeek, int digit, LocalTime time) {
       for (Schedule schedule : schedules) {
            if (daysOfWeek.contains(dayOfWeek) && restrictedDigits.contains(digit) && schedule.contains(time)) {
                return true;
            }
        }
        return false;
    }
}