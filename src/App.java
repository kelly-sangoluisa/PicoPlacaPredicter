import business.*;
import input.LicensePlate;
import output.ResultFormatter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        RuleSet ruleSet = setupDefaultRules();
        Predictor predictor = new Predictor(ruleSet);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha en el formato dd-MM-yyyy: ");
        String rawDate = scanner.nextLine();

        System.out.print("Ingrese la hora en el formato (HH:mm): ");
        String rawTime = scanner.nextLine();

        System.out.print("Ingrese la placa del vehículo (ej: ABC-1234): ");
        String fullPlate = scanner.nextLine();

        LicensePlate plate = new LicensePlate(fullPlate);
        if (!plate.validatePlate()) {
            System.out.println("Formato de placa inválido. Debe ser 3 letras y 3 o 4 dígitos.");
            return;
        }

        boolean result = predictor.predict(rawDate, rawTime, fullPlate);
        String message = ResultFormatter.formatResult(result);
        System.out.println(message);
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