package org.lessons.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Si prega di inserire nuovo evento");

        boolean flag = false;
        do {
            System.out.println("Inserisci titolo:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci data (dd/mm/yyyy):");
            String data = scanner.nextLine();

            System.out.println("Inserisci numero di posti a disposizione per l'evento:");
            int posti = Integer.parseInt(scanner.nextLine());

            Evento newEvento = new Evento(titolo, data, posti);
            flag = true;
        } while (!flag);

        scanner.close();
    }
}
