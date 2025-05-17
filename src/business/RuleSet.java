package business;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;


public class RuleSet {
    private final List<Rule> rules;

    public RuleSet() {
        this.rules = new ArrayList<>(6);
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public boolean hasRules() {
        return !rules.isEmpty();
    }

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