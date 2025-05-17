package com.app.input;

/**
 * The {@code LicensePlate} class is responsible for handling and validating vehicle license plates.
 * It provides methods to validate the format of an Ecuadorian license plate and to extract
 * the last digit from the plate number.
 * <p>
 * The expected format for an Ecuadorian license plate is three letters followed by three or four digits,
 * with or without a hyphen.
 * </p>
 *
 * Example usage:
 * <pre>
 *     LicensePlate plate = new LicensePlate("ABC-1234");
 *     boolean isValid = plate.validatePlate();
 *     int lastDigit = plate.getLastDigit("ABC-1234");
 * </pre>
 *
 * @author Kelly Sangoluisa
 */
public class LicensePlate {
    private String fullPlate;

     public LicensePlate(String fullPlate) {
        this.fullPlate = fullPlate;
    }

    /**
     * Validates the license plate format.
     * The plate must have three letters and three or four digits (Ecuadorian format).
     *
     * @return {@code true} if the plate format is valid, {@code false} otherwise
     */
    public boolean validatePlate() {
        //placa de ecuador: 3 letras y 3 o 4 digitos
        return fullPlate.matches("[A-Za-z]{3}-?\\d{3,4}");
    }

    /**
     * Returns the last digit of the license plate.
     *
     * @param plate the license plate string
     * @return the last digit if present, or -1 if not found
     */
    public int getLastDigit(String plate) {
        String cleanPlate = plate.replace("-", "");
        char lastChar = cleanPlate.charAt(cleanPlate.length() - 1);
        if (Character.isDigit(lastChar)) {
            return Character.getNumericValue(lastChar);
        } else {
            return -1;
        }
    }
}