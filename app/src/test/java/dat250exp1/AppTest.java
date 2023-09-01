/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dat250exp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void testInchesToMetersConversion() {
        // Input values
        double inputValue = 36.0; // 36 inches
        String fromUnit = "in";
        String toUnit = "m";

        // Expected result: 36 inches is equivalent to 0.9144 meters
        double expectedConversionResult = 0.9144;

        // Perform the conversion
        double actualResult = App.convertUnits(inputValue, fromUnit, toUnit);

        // Check if the actual result matches the expected result with a small tolerance
        double tolerance = 0.001; // Define a small tolerance for floating-point comparisons
        assertEquals(expectedConversionResult, actualResult, tolerance,
                "Inches to meters conversion failed. Expected: " + expectedConversionResult + " meters, Actual: " + actualResult);
    }

    @Test
    public void testFeetToMetersConversion() {
        // Input values
        double inputValue = 300.0; // 300 feet
        String fromUnit = "ft";
        String toUnit = "m";

        // Expected result: 36 inches is equivalent to 0.9144 meters
        double expectedConversionResult = 91.44;

        // Perform the conversion
        double actualResult = App.convertUnits(inputValue, fromUnit, toUnit);

        // Check if the actual result matches the expected result with a small tolerance
        double tolerance = 0.001; // Define a small tolerance for floating-point comparisons
        assertEquals(expectedConversionResult, actualResult, tolerance,
                "Feet to meters conversion failed. Expected: " + expectedConversionResult + " meters, Actual: " + actualResult);
    }

    @Test
    public void testMetersToMilesConversion() {
        // Input values
        double inputValue = 2300.0; // 2300 meters
        String fromUnit = "m";
        String toUnit = "mi";

        // Expected result: 36 inches is equivalent to 0.9144 meters
        double expectedConversionResult = 1.4291;

        // Perform the conversion
        double actualResult = App.convertUnits(inputValue, fromUnit, toUnit);

        // Check if the actual result matches the expected result with a small tolerance
        double tolerance = 0.001; // Define a small tolerance for floating-point comparisons
        assertEquals(expectedConversionResult, actualResult, tolerance,
                "Meters to miles conversion failed. Expected: " + expectedConversionResult + " miles, Actual: " + actualResult);
    }
}