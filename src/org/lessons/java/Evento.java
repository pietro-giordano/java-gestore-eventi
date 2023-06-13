package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Evento {
    private String titolo;
    private String data;
    private int nPostiTotali;
    private int nPostiPrenotati;

    public Evento(String titolo, String data, int nPostiTotali) {
        this.titolo = titolo;
        this.data = data;
        this.nPostiTotali = nPositivo(nPostiTotali);
        this.nPostiPrenotati = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getnPostiTotali() {
        return nPostiTotali;
    }

    public int getnPostiPrenotati() {
        return nPostiPrenotati;
    }

    public Integer nPositivo(int n) throws NumberFormatException {
        try {
            if (n > 0) {
                return n;
            } else {
                System.out.println("Numero inserito non valido!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Si prega di inserire un numero!");
        }
        return null;
    }

    public String comparatoreData(String input) throws DateTimeParseException {
        String regex = "\\d{2}/\\d{2}/\\d{4}";  // validator
        try {
            if(input.matches(regex)) {
                // formattatore
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                // parso stringa in data formattata
                LocalDate data = LocalDate.parse(input, formatter);
                // recupero data odierna
                LocalDate oggi = LocalDate.now();

                if (data.isAfter(oggi)) {
                    return input;
                } else {
                    System.out.println("La data inserita non è valida in quanto già passata!");
                    return null;
                }
            } else {
                throw new DateTimeParseException("Data errata", input, 0);
            }
        } catch (Exception e) {
            System.out.println("Formato data non valido");
            return null;
        }
    }
}
