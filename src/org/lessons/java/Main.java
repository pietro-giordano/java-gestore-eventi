package org.lessons.java;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Si prega di inserire nuovo evento");

        boolean flag = false;
        do {
            try {
                System.out.println("Inserisci titolo:");
                String titolo = scanner.nextLine();

                System.out.println("Inserisci data (dd/mm/yyyy):");
                String data = scanner.nextLine();

                System.out.println("Inserisci numero di posti a disposizione per il concerto:");
                int posti = Integer.parseInt(scanner.nextLine());

                System.out.println("Inserisci ora concerto:");
                String ora = scanner.nextLine();

                System.out.println("Inserisci prezzo concerto:");
                BigDecimal prezzo = scanner.nextBigDecimal();

                Concerto newConcerto = new Concerto(titolo, data, posti, ora, prezzo);
                flag = true;

                System.out.println(newConcerto.toString() + " è stato creato");
                boolean flag2 = false;
                do {
                    System.out.println("Adesso scegli cosa vuoi fare:\n" +
                            "1> Prenotazioni\n" +
                            "2> Disdette\n" +
                            "3> Controllo disponibilità posti\n" +
                            "4> Esci");
                    int n = Integer.parseInt(scanner.nextLine());
                    switch (n) {
                        case 1 -> {
                            System.out.println("Quanti posti vuoi prenotare?");
                            try {
                                for (int i = 0; i < Integer.parseInt(scanner.nextLine()); i++) {
                                    newConcerto.prenota();
                                }
                            } catch (PrenotationException e) {
                                System.out.println("Posti non disponibili o evento finito");
                            }
                        }
                        case 2 -> {
                            System.out.println("Quanti posti vuoi disdire?");
                            try {
                                for (int i = 0; i < Integer.parseInt(scanner.nextLine()); i++) {
                                    newConcerto.disdici();
                                }
                            } catch (PrenotationException e) {
                                System.out.println("Nessun posto da disdire o evento finito");
                            }
                        }
                        case 3 -> {
                            System.out.println("Posti prenotati: " + newConcerto.getnPostiPrenotati());
                            System.out.println("Posti disponibili: " + (newConcerto.getnPostiTotali() + newConcerto.getnPostiPrenotati()));
                        }
                        case 4 -> flag2 = true;
                        default -> System.out.println("Input errato");
                    }
                } while (!flag2);
            } catch (EventoCreateException e) {
                System.out.println("Valore inserito in fase di creazione non valido");
            } catch (NumberFormatException e) {
                System.out.println("Numero posti a disposione non valido");
            } catch (InvalidDateException e) {
                System.out.println("Data non valida");
            } catch (InvalidPriceException e) {
                System.out.println("Prezzo non valido");
            } catch (InvalidTimeException e) {
                System.out.println("Orario non valido");
            }
        } while (!flag);

        scanner.close();
    }
}
