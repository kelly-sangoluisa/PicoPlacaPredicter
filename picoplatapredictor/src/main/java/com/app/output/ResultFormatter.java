package com.app.output;

public class ResultFormatter {
    
    public static String formatResult(boolean canDrive) {
        return canDrive 
            ? "You are NOT allowed to drive due to 'Pico y Placa' regulations." 
            : "You are allowed to drive at this time." ;
    }
}