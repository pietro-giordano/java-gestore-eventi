package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private String data;
    private int nPostiTotali;
    private int nPostiPrenotati;

    public Evento(String titolo, String data, int nPostiTotali) {
        this.titolo = titolo;
        this.data = validatoreData(data);
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

    public boolean comparatoreData(String date) {
        // formattatore
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // parso stringa in data formattata
        LocalDate data = LocalDate.parse(date, formatter);
        // recupero data odierna
        LocalDate oggi = LocalDate.now();

        if (data.isAfter(oggi)) {
            return true;
        } else {
            return false;
        }
    }

    public String validatoreData(String input) throws RuntimeException {
        String regex = "\\d{2}/\\d{2}/\\d{4}";  // validatore
        try {
            if(input.matches(regex)) {
                if (comparatoreData(input)) {
                    return input;
                } else {
                    System.out.println("La data inserita non è valida in quanto già passata!");
                    return null;
                }
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("Formato data non valido");
            return null;
        }
    }

    public int prenota() throws RuntimeException {
        try {
            if (comparatoreData(this.data) && (nPostiTotali - nPostiPrenotati) > 0) {
                return this.nPostiPrenotati++;
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("Evento concluso o posti disponibili finiti!");
            return this.nPostiPrenotati;
        }
    }

    public int disdici() throws RuntimeException {
        try {
            if (comparatoreData(this.data) && nPostiPrenotati == 0) {
                return this.nPostiPrenotati--;
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("Evento concluso o nessun posto prenotato!");
            return this.nPostiPrenotati;
        }
    }

    @Override
    public String toString() {
        return "Evento{" + data + titolo +'}';
    }
}
