package com.app.output;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultFormatterTest {

    @Test
    void testFormatResultCanDrive() {
        String result = ResultFormatter.formatResult(true);
        assertEquals("You are allowed to drive at this time.", result);
    }

    @Test
    void testFormatResultCannotDrive() {
        String result = ResultFormatter.formatResult(false);
        assertEquals("You are NOT allowed to drive due to 'Pico y Placa' regulations.", result);
    }
}