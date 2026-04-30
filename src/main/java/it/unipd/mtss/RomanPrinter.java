////////////////////////////////////////////////////////////////////
// LAURA GRANESE 2145592
// SOFIA BORTOLOTTO 2147989
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

// Converte un numero romano in ASCII art
public class RomanPrinter {

    public static String print(int num) {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    // Trasforma una stringa romana in ASCII art multi-linea
    private static String printAsciiArt(String romanNumber) {

        // Controllo input: non può essere nullo o vuoto
        if (romanNumber == null || romanNumber.isEmpty()) {
            throw new IllegalArgumentException("String cannot be empty");
        }

        // Converte ogni lettera nella sua rappresentazione ASCII
        String[][] ascii = composeAscii(romanNumber);

        StringBuilder output = new StringBuilder();

        /*
         * Costruzione output:
         * 6 righe totali (altezza ASCII art)
         * ogni riga è composta concatenando le pezzi di ogni lettera ronana 
         */
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < ascii.length; j++) {
                output.append(ascii[j][i]);
            }
            if (i < 5) {
                output.append("\n");
            }
        }

        return output.toString();
    }

  
    /*
     Converte la stringa romana in una matrice:
     ogni riga = una lettera romana
     ogni colonna = una riga ASCII (6 righe totali)
     */
    
    private static String[][] composeAscii(String romanNumber) {
        String[][] out = new String[romanNumber.length()][6];

        for (int i = 0; i < romanNumber.length(); i++) {
            char c = romanNumber.charAt(i);

            switch (c) {
                case 'I': out[i] = printAscii_I(); break;
                case 'V': out[i] = printAscii_V(); break;
                case 'X': out[i] = printAscii_X(); break;
                case 'L': out[i] = printAscii_L(); break;
                case 'C': out[i] = printAscii_C(); break;
                case 'D': out[i] = printAscii_D(); break;
                case 'M': out[i] = printAscii_M(); break;
                default:
                    throw new IllegalArgumentException("Invalid Roman character");
            }
        }

        return out;
    }

    // Ogni metodo restituisce l'ASCII delle lettere romane (6 righe fisse)

    private static String[] printAscii_I() {
        return new String[] {
            "  _____   ",
            " |_   _|  ",
            "   | |    ",
            "   | |    ",
            "  _| |_   ",
            " |_____|  "
        };
    }

    private static String[] printAscii_V() {
        return new String[] {
            "__      __",
            "\\ \\    / /",
            " \\ \\  / / ",
            "  \\ \\/ /  ",
            "   \\  /   ",
            "    \\/    "
        };
    }

    private static String[] printAscii_X() {
        return new String[] {
                " __    __ ",
                " \\ \\  / / ",
                "  \\ \\/ /  ",
                "   >  <   ",
                "  / /\\ \\  ",
                " /_/  \\_\\ "
        };
    }

    private static String[] printAscii_L() {
        return new String[] {
            "  _       ",
            " | |      ",
            " | |      ",
            " | |      ",
            " | |____  ",
            " |______| "
        };
    }

    private static String[] printAscii_C() {
        return new String[] {
            "   _____  ",
            "  / ____| ",
            " | |      ",
            " | |      ",
            " | |____  ",
            "  \\_____| "
        };
    }

    private static String[] printAscii_D() {
        return new String[] {
            "  _____   ",
            " |  __ \\  ",
            " | |  | | ",
            " | |  | | ",
            " | |__| | ",
            " |_____/  "
        };
    }

    private static String[] printAscii_M() {
        return new String[] {
            "  __  __  ",
            " |  \\/  | ",
            " | \\  / | ",
            " | |\\/| | ",
            " | |  | | ",
            " |_|  |_| "
        };
    }
}
