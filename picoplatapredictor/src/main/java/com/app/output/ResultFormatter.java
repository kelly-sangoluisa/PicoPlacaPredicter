package com.app.output;

public class ResultFormatter {
    
    public static String formatResult(boolean canDrive) {
        return canDrive 
            ? "Puede circular normalmente." 
            : "No puede circular debido a restricciones de pico y placa.";
    }
}