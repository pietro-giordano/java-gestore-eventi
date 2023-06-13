package org.lessons.java;

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

                System.out.println("Inserisci numero di posti a disposizione per l'evento:");
                int posti = Integer.parseInt(scanner.nextLine());

                Evento newEvento = new Evento(titolo, data, posti);
                flag = true;
                System.out.println(newEvento.toString() + "è stato creato");


            } catch (EventoCreateException e) {
                System.out.println("Valore inserito in fase di creazione non valido");
            } catch (NumberFormatException e) {
                System.out.println("Numero posti a disposione non valido");
            } catch (InvalidDateException e) {
                System.out.println("Data non valida");
            }
        } while (!flag);

        scanner.close();
    }
}
