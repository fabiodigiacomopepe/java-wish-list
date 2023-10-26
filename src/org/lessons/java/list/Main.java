package org.lessons.java.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inizializzo lo scanner da tastiera
        Scanner scan = new Scanner(System.in);

        // Creo ArrayList di regali
        List<String> regali = new ArrayList<>();

        int Risposta = 0;
        boolean exit = false;
        while (!exit) {
            // Chiedo a utente cosa vuole fare
            System.out.println("Vuoi aggiungere un regalo alla lista?");
            System.out.println("1 - Sì");
            System.out.println("2 - No");
            System.out.print("Seleziona un numero: ");
            String rispostaString = scan.nextLine();
            // Provo a convertire il numero ricevuto dallo scanner in un intero
            try {
                Risposta = Integer.parseInt(rispostaString);
                // Se riesco a convertire ed è compreso fra 1 e 2
                if (Risposta > 0 && Risposta < 3) {
                    if (Risposta == 1) {
                        exit = false;

                        // Chiedo descrizione e destinatario
                        System.out.println("Inserisci descrizione regalo:");
                        String descrizione = scan.nextLine();
                        System.out.println("Inserisci destinatario regalo:");
                        String destinatario = scan.nextLine();
                        // Creo un nuovo oggetto Regalo passando come paramentri quelli dello scanner
                        Regalo regalo = new Regalo(descrizione, destinatario);
                        // Aggiungo il regalo all'ArrayList
                        regali.add(String.valueOf(regalo));
                        // Stampo lughezza lista e regalo appena creato
                        System.out.println("Lunghezza lista regali: " + regali.size());
                        System.out.println(regalo);
                    } else if (Risposta == 2) {
                        // Esco dal loop
                        exit = true;

                        // Stampo lista completa a video
                        System.out.println(regali);
                    }
                } // Altrimenti
                else {
                    System.out.println("Inserire un numero compreso fra 1 e 2.");
                    exit = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserire un numero.");
                exit = false;
            }
            System.out.println("---------------");
        }

        // Chiudo lo scanner da tastiera
        scan.close();
    }
}
