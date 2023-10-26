package org.lessons.java.list;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inizializzo lo scanner da tastiera
        Scanner scan = new Scanner(System.in);

        // Creo ArrayList di regali
        List<Regalo> regali = new ArrayList<>();

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
                        regali.add(regalo);
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

        // Inizializzo a null il FileWriter
        FileWriter fileWriter = null;
        try {
            // Provo ad aprirlo (metto true per non sovrascrivere)
            fileWriter = new FileWriter("./resources/data.txt", true);
            // Provo a scriverci sopra
            for (int i = 0; i < regali.size(); i++) {
                fileWriter.write("Regalo");
                fileWriter.write("\nDescrizione: " + regali.get(i).getDescrizione());
                fileWriter.write("\nDestinatario: " + regali.get(i).getDestinatario() + "\n \n");
            }
        } // Se si solleva un'eccezione passo dal catch
        catch (IOException e) {
            System.out.println("Impossibile scrivere sul file.");
        } // Sia che ho terminato il try, sia che sono entrato nel catch passo di qui
        finally {
            try {
                // Se il fileWriter è diverso da null, lo chiudo
                if (fileWriter != null) {
                    System.out.println("Chiudo il file.");
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Provo a leggere il file
        Scanner fileReader = null;
        try {
            // Setto file da leggere
            fileReader = new Scanner(new File("./resources/data.txt"));
            // Creo loop finchè viene trovata una nuova riga
            while (fileReader.hasNextLine()) {
                // Stampo riga
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
}
