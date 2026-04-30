////////////////////////////////////////////////////////////////////
// LAURA GRANESE 2145592
// SOFIA BORTOLOTTO 2147989
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerToRomanTest {

    // --- SEZIONE 1: ECCEZIONI (BOUNDARY - RIGHT BICEP) ---

    @Test
    public void testConvert_InputIsZero_ShouldThrowException() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(0);
        });
    }

    @Test
    public void testConvert_InputIsNegative_ShouldThrowException() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(-1);
        });
    }

    @Test
    public void testConvert_InputIsOverOneThousand_ShouldThrowException() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(1001);
        });
    }

    // --- SEZIONE 2: CONVERSIONI STANDARD (RIGHT - A-TRIP) ---

    @Test
    public void testConvert_InputIsValidBasicNumbers_ShouldReturnCorrectRoman() {
        // Arrange, Act & Assert
        assertEquals("I", IntegerToRoman.convert(1));
        assertEquals("V", IntegerToRoman.convert(5));
        assertEquals("X", IntegerToRoman.convert(10));
        assertEquals("L", IntegerToRoman.convert(50));
        assertEquals("C", IntegerToRoman.convert(100));
        assertEquals("D", IntegerToRoman.convert(500));
        assertEquals("M", IntegerToRoman.convert(1000));
    }

    @Test
    public void testConvert_InputIsComplexNumbers_ShouldReturnCorrectRoman() {
        // Test di numeri con sottrazioni e combinazioni (Thorough)
        assertEquals("IV", IntegerToRoman.convert(4));
        assertEquals("IX", IntegerToRoman.convert(9));
        assertEquals("XL", IntegerToRoman.convert(40));
        assertEquals("XC", IntegerToRoman.convert(90));
        assertEquals("CD", IntegerToRoman.convert(400));
        assertEquals("CM", IntegerToRoman.convert(900));
        assertEquals("CMXCIX", IntegerToRoman.convert(999));
    }

    // --- SEZIONE 3: TEST DI COERENZA E ALTERNATIVI ---

    @Test
    public void testConvert_CompareWithAlternativeImplementation_ShouldBeEqual() {
        // Verifica che ogni numero da 1 a 1000 produca lo stesso risultato
        // della versione alternativa (Cross-check)
        for (int i = 1; i <= 1000; i++) {
            assertEquals(convertAlternative(i), IntegerToRoman.convert(i),
                    "Errore di corrispondenza al numero: " + i);
        }
    }

    @Test
    public void testConvert_ReverseConversion_ShouldReturnOriginalNumber() {
        // Inverse Relationship Test (Right BICEP)
        for (int i = 1; i <= 1000; i++) {
            String roman = IntegerToRoman.convert(i);
            assertEquals(i, reverseConvert(roman),
                    "La conversione inversa è fallita per: " + i);
        }
    }

    // --- METODI DI UTILITY (NON SONO TEST) ---

    private static int reverseConvert(String roman) {
        int total = 0;
        int prevValue = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int value = getRomanValue(roman.charAt(i));
            if (value < prevValue) {
                total -= value;
            } else {
                total += value;
            }
            prevValue = value;
        }
        return total;
    }

    private static int getRomanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    private static String convertAlternative(int number) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number > 0) {
            if (number >= values[i]) {
                result.append(numerals[i]);
                number -= values[i];
            } else {
                i++;
            }
        }
        return result.toString();
    }
}