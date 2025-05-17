package business;

import java.time.LocalTime;

public class Schedule {
    private LocalTime startTime;
    private LocalTime endTime;

    public Schedule(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean contains(LocalTime time) {
        return !time.isBefore(startTime) && !time.isAfter(endTime);
    }
}