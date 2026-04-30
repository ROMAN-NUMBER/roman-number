////////////////////////////////////////////////////////////////////
// LAURA GRANESE 2145592
// SOFIA BORTOLOTTO 2147989
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanPrinterTest {

        // --- TEST DEI CASI LIMITE (BOUNDARY / RIGHT BICEP) ---

        @Test
        public void testPrint_InputIsZero_ShouldThrowException() {
                // Arrange
                int input = 0;

                // Act & Assert
                assertThrows(IllegalArgumentException.class, () -> {
                        RomanPrinter.print(input);
                });
        }

        @Test
        public void testPrint_InputIsNegative_ShouldThrowException() {
                // Arrange
                int input = -1;

                // Act & Assert
                assertThrows(IllegalArgumentException.class, () -> {
                        RomanPrinter.print(input);
                });
        }

        @Test
        public void testPrint_InputIsOverOneThousand_ShouldThrowException() {
                // Arrange
                int input = 1001;

                // Act & Assert
                assertThrows(IllegalArgumentException.class, () -> {
                        RomanPrinter.print(input);
                });
        }

        // --- TEST DELLE PIETRE MILIARI DELLA CONSEGNA (COPERTURA > 85%) ---

        @Test
        public void testPrint_InputIsThree_ShouldReturnAsciiForIII() {
                // Arrange
                int input = 3;
                String expected = "  _____     _____     _____   \n" +
                                " |_   _|   |_   _|   |_   _|  \n" +
                                "   | |       | |       | |    \n" +
                                "   | |       | |       | |    \n" +
                                "  _| |_     _| |_     _| |_   \n" +
                                " |_____|   |_____|   |_____|  ";

                // Act
                String actual = RomanPrinter.print(input);

                // Assert
                assertEquals(expected, actual);
        }

        @Test
        public void testPrint_InputIsSix_ShouldReturnAsciiForVI() {
                // Arrange
                int input = 6;
                String expected = "__      __  _____   \n" +
                                "\\ \\    / / |_   _|  \n" +
                                " \\ \\  / /    | |    \n" +
                                "  \\ \\/ /     | |    \n" +
                                "   \\  /     _| |_   \n" +
                                "    \\/     |_____|  ";

                // Act
                String actual = RomanPrinter.print(input);

                // Assert
                assertEquals(expected, actual);
        }

        @Test
        public void testPrint_InputIsTwenty_ShouldReturnAsciiForXX() {
                // Act
                String actual = RomanPrinter.print(20);

                // Assert
                // Controlliamo solo che la stringa contenga i pezzi fondamentali delle X
                org.junit.jupiter.api.Assertions.assertTrue(actual.contains(">  <"));
                org.junit.jupiter.api.Assertions.assertTrue(actual.contains("__"));
        }

        @Test
        public void testPrint_InputIsFifty_ShouldReturnAsciiForL() {
                // Arrange
                int input = 50;
                String expected = "  _       \n" +
                                " | |      \n" +
                                " | |      \n" +
                                " | |      \n" +
                                " | |____  \n" +
                                " |______| ";

                // Act
                String actual = RomanPrinter.print(input);

                // Assert
                assertEquals(expected, actual);
        }

        @Test
        public void testPrint_InputIsOneHundred_ShouldReturnAsciiForC() {
                // Arrange
                int input = 100;
                String expected = "   _____  \n" +
                                "  / ____| \n" +
                                " | |      \n" +
                                " | |      \n" +
                                " | |____  \n" +
                                "  \\_____| ";

                // Act
                String actual = RomanPrinter.print(input);

                // Assert
                assertEquals(expected, actual);
        }

        @Test
        public void testPrint_InputIsFiveHundred_ShouldReturnAsciiForD() {
                // Arrange
                int input = 500;
                String expected = "  _____   \n" +
                                " |  __ \\  \n" +
                                " | |  | | \n" +
                                " | |  | | \n" +
                                " | |__| | \n" +
                                " |_____/  ";

                // Act
                String actual = RomanPrinter.print(input);

                // Assert
                assertEquals(expected, actual);
        }

        @Test
        public void testPrint_InputIsOneThousand_ShouldReturnAsciiForM() {
                // Arrange
                int input = 1000;
                String expected = "  __  __  \n" +
                                " |  \\/  | \n" +
                                " | \\  / | \n" +
                                " | |\\/| | \n" +
                                " | |  | | \n" +
                                " |_|  |_| ";

                // Act
                String actual = RomanPrinter.print(input);

                // Assert
                assertEquals(expected, actual);
        }

        @Test
        public void testPrint_InputIsNineHundredNinetyNine_ShouldReturnAsciiForCMXCIX() {
                // Arrange
                int input = 999;
                String expected = "   _____    __  __   __    __    _____    _____    __    __ \n" +
                                "  / ____|  |  \\/  |  \\ \\  / /   / ____|  |_   _|   \\ \\  / / \n" +
                                " | |       | \\  / |   \\ \\/ /   | |         | |      \\ \\/ /  \n" +
                                " | |       | |\\/| |    >  <    | |         | |       >  <   \n" +
                                " | |____   | |  | |   / /\\ \\   | |____    _| |_     / /\\ \\  \n" +
                                "  \\_____|  |_|  |_|  /_/  \\_\\   \\_____|  |_____|   /_/  \\_\\ ";

                // Act
                String actual = RomanPrinter.print(input);

                // Assert
                assertEquals(expected, actual);
        }
}