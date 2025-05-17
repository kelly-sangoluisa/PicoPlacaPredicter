package business;

import input.DateInput;
import input.LicensePlate;
import input.TimeInput;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Predictor {
    private DateInput date;
    private TimeInput time;
    private LicensePlate plate;

    private final RuleSet ruleSet;

    public Predictor(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    public void setDate(DateInput date) {
        this.date = date;
    }

    public void setTime(TimeInput time) {
        this.time = time;
    }

    public void setPlate(LicensePlate plate) {
        this.plate = plate;
    }

    public boolean predict(String rawDate, String rawTime, String fullPlate) {
        setDate(new DateInput(rawDate));
        setTime(new TimeInput(rawTime));
        setPlate(new LicensePlate(fullPlate));

        LocalDate parsedDate = date.parseDate(rawDate);
        LocalTime parsedTime = time.parseTime(rawTime);
        DayOfWeek dayOfTheWeek = parsedDate.getDayOfWeek();
        int lastDigit = plate.getLastDigit(fullPlate);
        return ruleSet.hasRestriction(dayOfTheWeek, lastDigit, parsedTime);
    }
}