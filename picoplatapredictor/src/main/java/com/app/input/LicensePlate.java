package com.app.input;

public class LicensePlate {
    private String fullPlate;

     public LicensePlate(String fullPlate) {
        this.fullPlate = fullPlate;
    }

    public boolean validatePlate() {
        //placa de ecuador: 3 letras y 3 o 4 digitos
        return fullPlate.matches("[A-Za-z]{3}-?\\d{3,4}");
    }

    public int getLastDigit(String fullPlate) {
        char lastDigiString = fullPlate.charAt(fullPlate.length() - 1);
        int lastDigit = Character.getNumericValue(lastDigiString);
        return lastDigit;
    }
}