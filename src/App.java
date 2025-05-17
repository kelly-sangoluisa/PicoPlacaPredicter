import business.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        
    }

    private static RuleSet setupDefaultRules() {
        RuleSet ruleSet = new RuleSet();

        List<Schedule> horariosRestriccion = Arrays.asList(
                new Schedule(LocalTime.of(6, 0), LocalTime.of(9, 30)),
                new Schedule(LocalTime.of(16, 0), LocalTime.of(20, 0))
        );

        ruleSet.addRule(new Rule(Arrays.asList(DayOfWeek.MONDAY), Arrays.asList(1, 2), horariosRestriccion));
        ruleSet.addRule(new Rule(Arrays.asList(DayOfWeek.TUESDAY), Arrays.asList(3, 4), horariosRestriccion));
        ruleSet.addRule(new Rule(Arrays.asList(DayOfWeek.WEDNESDAY), Arrays.asList(5, 6), horariosRestriccion));
        ruleSet.addRule(new Rule(Arrays.asList(DayOfWeek.THURSDAY), Arrays.asList(7, 8), horariosRestriccion));
        ruleSet.addRule(new Rule(Arrays.asList(DayOfWeek.FRIDAY), Arrays.asList(9, 0), horariosRestriccion));

        return ruleSet;
    }
}