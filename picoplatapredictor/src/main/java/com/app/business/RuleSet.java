package com.app.business;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code RuleSet} class manages a collection of {@link Rule} objects.
 * It provides methods to add new rules and to check if a given combination
 * of day, license plate digit, and time is restricted according to any rule in the set.
 * <p>
 * This class is used to encapsulate all restriction rules and to evaluate
 * whether a restriction applies for a specific scenario.
 * </p>
 *
 * Example usage:
 * <pre>
 *     RuleSet ruleSet = new RuleSet();
 *     ruleSet.addRule(rule);
 *     boolean restricted = ruleSet.hasRestriction(DayOfWeek.MONDAY, 1, LocalTime.of(8, 0));
 * </pre>
 *
 * @author Kelly Sangoluisa
 */
public class RuleSet {
    private final List<Rule> rules;

    /**
     * Constructs an empty RuleSet with an initial capacity for six rules.
     */
    public RuleSet() {
        this.rules = new ArrayList<>(6);
    }

    /**
     * Adds a new rule to the rule set.
     *
     * @param rule the {@link Rule} to add
     */
    public void addRule(Rule rule) {
        rules.add(rule);
    }

    /**
     * Checks if the rule set contains any rules.
     *
     * @return {@code true} if there is at least one rule, {@code false} otherwise
     */
    public boolean hasRules() {
        return !rules.isEmpty();
    }

    /**
     * Determines if there is a restriction for the given day, digit, and time
     * according to any rule in the set.
     *
     * @param dayOfWeek the day of the week to check
     * @param digit the last digit of the license plate to check
     * @param time the time to check
     * @return {@code true} if any rule restricts this combination, {@code false} otherwise
     */
    public boolean hasRestriction(DayOfWeek dayOfWeek, int digit, LocalTime time) {
        if (!hasRules()) return false;

        for (Rule rule : rules) {
            if (rule.isRestricted(dayOfWeek, digit, time)) {
                return true;
            }
        }
        return false;
    }
}