package com.app.business;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import com.app.input.DateInput;
import com.app.input.LicensePlate;
import com.app.input.TimeInput;

/**
 * The {@code Predictor} class is responsible for determining whether a vehicle
 * is subject to driving restrictions based on the provided date, time, and license plate.
 * It uses a set of rules defined in a {@link RuleSet} to evaluate the restriction.
 * <p>
 * This class encapsulates the logic for parsing user input and applying the restriction rules.
 * </p>
 *
 * @author Kelly Sangoluisa
 */
public class Predictor {
    private DateInput date;
    private TimeInput time;
    private LicensePlate plate;

    private final RuleSet ruleSet;

    /**
     * Constructs a Predictor with the specified rule set.
     *
     * @param ruleSet the set of rules to be used for prediction
     */
    public Predictor(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    /**
     * Sets the date input for prediction.
     *
     * @param date the date input
     */
    public void setDate(DateInput date) {
        this.date = date;
    }

    /**
     * Sets the time input for prediction.
     *
     * @param time the time input
     */
    public void setTime(TimeInput time) {
        this.time = time;
    }

    /**
     * Sets the license plate input for prediction.
     *
     * @param plate the license plate input
     */
    public void setPlate(LicensePlate plate) {
        this.plate = plate;
    }

    /**
     * Predicts whether the vehicle with the given license plate is restricted
     * at the specified date and time.
     *
     * @param rawDate   the date as a string (format: dd-MM-yyyy)
     * @param rawTime   the time as a string (format: HH:mm)
     * @param fullPlate the full license plate string
     * @return {@code true} if the vehicle is restricted, {@code false} otherwise
     */
    public boolean predict(String rawDate, String rawTime, String fullPlate) {
        setDate(new DateInput(rawDate));
        setTime(new TimeInput(rawTime));
        setPlate(new LicensePlate(fullPlate));

        LocalDate parsedDate = date.parseDate();
        LocalTime parsedTime = time.parseTime();
        DayOfWeek dayOfTheWeek = parsedDate.getDayOfWeek();
        int lastDigit = plate.getLastDigit(fullPlate);
        return ruleSet.hasRestriction(dayOfTheWeek, lastDigit, parsedTime);
    }
}