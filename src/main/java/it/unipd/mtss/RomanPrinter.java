////////////////////////////////////////////////////////////////////
// LAURA GRANESE 2145592
// SOFIA BORTOLOTTO 2147989
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

//converte un numero romano in ASCII
public class RomanPrinter {
    public static String print(int num){
      return printAsciiArt(IntegerToRoman.convert(num));
    }

// Trasforma una stringa romana in ASCII art multi-linea
    private static String printAsciiArt(String romanNumber){4
      // Controllo input: non può essere null o vuoto
      if(romanNumber == null || romanNumber.isEmpty()) {
        throw new IllegalArgumentException("String can't be empty"); 
      }
// Converte ogni carattere romano nel suo array ASCII
      String[][] ascii = composeAscii(romanNumber);

      StringBuilder output = new StringBuilder();

            
      /*
         * Costruzione output finale:
         * - 6 righe (altezza ASCII art)
         * - per ogni riga, concatena i pezzi di ogni lettera romana
         */

      for(int i=0; i<6; i++) {
        for(int j=0; j<ascii.length; j++) {
          if(ascii[j] != null && ascii[j][i] != null) {
            output.append(ascii[j][i]); 
          }
        }
        if(i<5){
          output.append("\n"); // nuova riga ASCII
        }
      } 
      return output.toString();
    }

    /*
     * Converte la stringa romana in una matrice:
     * ogni riga = una lettera romana
     * ogni colonna = una riga ASCII (6 righe totali)
     */

    private static String[][] composeAscii(String romanNumber) {
      String[][] out = new String[romanNumber.length()][6];
      for(int i=0; i<romanNumber.length(); i++) {
        char c = romanNumber.charAt(i);
        switch(c) {
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

    /*
     * Ogni metodo seguente restituisce
     * la rappresentazione ASCII di una singola lettera romana
     * (6 righe fisse)
     */

    private static String[] printAscii_I() {
        return new String[] {"  _____   ",
                             " |_   _|  ",
                             "   | |    ",
                             "   | |    ",
                             "  _| |_   ",
                             " |_____|  "};
    }

    private static String[] printAscii_V() {
        return new String[] {"__      __",
                             "\\ \\    / /",
                             " \\ \\  / / ",
                             "  \\ \\/ /  ",
                             "   \\  /   ",
                             "    \\/    ",};
    }

    private static String[] printAscii_X() {
        return new String[] {" __    __ ",
                             " \\ \\  / / ",
                             "  \\ \\/ /  ",
                             "   >  <   ",
                             "  / /\\ \\  ",
                             " /_/  \\_\\ "};
    }

    private static String[] printAscii_L() {
        return new String[] {"  _       ",
                             " | |      ",
                             " ! |      ",
                             " | |      ",
                             " | |____  ",
                             " |______| "};
    }

    private static String[] printAscii_C() {
        return new String[] {"   _____  ",
                             "  / ____| ",
                             " | |      ",
                             " | |      ",
                             " | |____  ",
                             "  \\_____| "};
    }

    private static String[] printAscii_D() {
        return new String[] {"  _____   ",
                             " |  __ \\  ",
                             " | |  | | ",
                             " | |  | | ",
                             " | |__| | ",
                             " |_____/  "};
    } 

    private static String[] printAscii_M() {
        return new String[] {"  __  __  ",
                             " |  \\/  | ",
                             " | \\  / | ",
                             " | |\\/| | ",
                             " | |  | | ",
                             " |_|  |_| "};
    }
}