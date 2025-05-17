package com.app.output;

/**
 * The {@code ResultFormatter} class provides utility methods to format the result
 * of the 'Pico y Placa' restriction check for user-friendly output.
 * <p>
 * It contains a static method to generate a message indicating whether the user
 * is allowed to drive based on the restriction evaluation.
 * </p>
 *
 * Example usage:
 * <pre>
 *     String message = ResultFormatter.formatResult(true);
 * </pre>
 *
 * @author Kelly Sangoluisa
 */
public class ResultFormatter {
    
    /**
     * Formats the result of the 'Pico y Placa' check into a user-friendly message.
     *
     * @param canDrive {@code true} if the user is NOT allowed to drive, {@code false} otherwise
     * @return a formatted message indicating the driving permission
     */
    public static String formatResult(boolean canDrive) {
        return canDrive 
            ? "You are NOT allowed to drive due to 'Pico y Placa' regulations." 
            : "You are allowed to drive at this time." ;
    }
}