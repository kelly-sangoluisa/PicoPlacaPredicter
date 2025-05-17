package com.app.output;

public class ResultFormatter {
    
    public static String formatResult(boolean canDrive) {
        return canDrive 
            ? "You are allowed to drive at this time." 
            : "You are NOT allowed to drive due to 'Pico y Placa' regulations.";
    }
}