////////////////////////////////////////////////////////////////////
// LAURA GRANESE 2145592
// SOFIA BORTOLOTTO 2147989
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

public class IntegerToRoman {
    
    /**
     * Converte un numero intero (1-1000) nella sua rappresentazione romana.
     *
     * PRE: number deve essere compreso tra 1 e 1000 inclusi
     * POST: ritorna una stringa contenente il numero romano corrispondente
     *
    */
    public static String convert(int number){

        // Controllo del range valido
        if (number <= 0 || number > 1000) {
            throw new IllegalArgumentException("Il numero deve essere compreso tra 1 e 1000");
        }

        //Tabelle di conversione (ordinate dalla più grande alla più piccola)
        String[] roman = {"M","CM","D","CD","C","XC","L",
                          "XL","X","IX","V","IV","I"};
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        //// StringBuilder usato per costruire la stringa in modo efficiente
        StringBuilder result = new StringBuilder();

        /*Il ciclo fa: 
        
        Scorre tutti i valori dal più grande al più piccolo
        Tipo: i = 0 allora 1000 (M), i = 1 allora 900 (CM), i = 2 allora 500 (D) 
        alla fine i = ultimo 1 (I)

        finché il numero è ≥ del valore corrente, allora aggiungo simbolo 
        sottraggo il valore
        */
        for(int i = 0; i < arab.length; i++) {
            // Ciclo che scorre tutti i valori arabi
            // Parte dal più grande (1000) fino al più piccolo (1)

            while(number >= arab[i]) {
                // Finché il nostro numero è maggiore o uguale al valore corrente
                // significa che possiamo usare quel simbolo romano
                
                result.append(roman[i]);

                // Aggiunge il simbolo romano corrispondente al risultato
                // es: se arab[i] = 50 → aggiunge "L"
                
                number -= arab[i];

                // Sottrae il valore usato dal numero
                // es: 58 - 50 = 8
            }

            // Quando il numero diventa più piccolo di arab[i],
            // passa al valore successivo (più piccolo)
        }

        return result.toString();
    }
}