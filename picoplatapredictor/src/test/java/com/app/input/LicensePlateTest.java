package com.app.input;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LicensePlateTest {

    @Test
    void testValidatePlate_ValidPlates() {
        assertTrue(new LicensePlate("ABC123").validatePlate());
        assertTrue(new LicensePlate("ABC-123").validatePlate());
        assertTrue(new LicensePlate("XYZ1234").validatePlate());
        assertTrue(new LicensePlate("XYZ-1234").validatePlate());
    }

    @Test
    void testValidatePlate_InvalidPlates() {
        assertFalse(new LicensePlate("AB123").validatePlate()); // only 2 letters
        assertFalse(new LicensePlate("ABCD123").validatePlate()); // 4 letters
        assertFalse(new LicensePlate("ABC12").validatePlate()); // only 2 digits
        assertFalse(new LicensePlate("ABC12345").validatePlate()); // 5 digits
        assertFalse(new LicensePlate("123ABC").validatePlate()); // digits first
        assertFalse(new LicensePlate("A1B2C3").validatePlate()); // mixed
        assertFalse(new LicensePlate("ABC-12A").validatePlate()); // letter in digits
    }

    @Test
    void testGetLastDigit_ValidPlate() {
        LicensePlate plate = new LicensePlate("ABC1234");
        assertEquals(4, plate.getLastDigit("ABC1234"));
        assertEquals(3, plate.getLastDigit("ABC123"));
        assertEquals(5, plate.getLastDigit("XYZ-125"));
    }

    @Test
    void testGetLastDigit_NonDigitAtEnd() {
        LicensePlate plate = new LicensePlate("ABC123A");
        int result = plate.getLastDigit("ABC123A");
        assertEquals(-1, result); // Character.getNumericValue('A') returns 10, but for non-digit, you may want to check this
    }

    @Test
    void testConstructorStoresFullPlate() {
        LicensePlate plate = new LicensePlate("ABC123");
        assertTrue(plate.validatePlate());
    }
}