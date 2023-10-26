package org.lessons.java.occurrence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inizializzo lo scanner da tastiera
        Scanner scan = new Scanner(System.in);

        // Chiedo all'utente di inserire una parola
        System.out.print("Inserisci una parola: ");
        String parola = scan.nextLine();

        // Creo una mappa di occorrenze
        Map<Character, Integer> occorrenze = new HashMap<>();

        // Itero su ogni carattere della parola
        for (char carattere : parola.toCharArray()) {
            // Con "occorrenze.getOrDefault(carattere, 0)"
            // Restituisco in numero, quante volte è presente il carattere nell'array
            // (Se il carattere non è presente nell'array, setto come valore di default 0)
            // Successivamente incremento di 1 il valore e con "occorrenze.put" metto tutto nel Map
            occorrenze.put(carattere, occorrenze.getOrDefault(carattere, 0) + 1);
        }

        // Stampo il numero di occorrenze per ogni carattere
        // // Itero su ogni chiave/valore dell'array
        for (Map.Entry<Character, Integer> entry : occorrenze.entrySet()) {
            // Stampo per ogni chiave (entry.getKey()) quante volta è stato trovato (entry.getValue())
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Chiudo lo scanner da tastiera
        scan.close();
    }
}
