package input;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateInput {
    private String rawDate;
   
    public DateInput(String rawDate) {
        this.rawDate = rawDate;
    }
    
    public LocalDate parseDate(String rawDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(rawDate, formatter);
    }

    public DayOfWeek getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek();
    }

}