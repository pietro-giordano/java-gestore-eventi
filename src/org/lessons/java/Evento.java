package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private String data;
    private int nPostiTotali;
    private int nPostiPrenotati;

    public Evento(String titolo, String data, int nPostiTotali) throws EventoCreateException, InvalidDateException {
        if (!titolo.isBlank() || !data.isBlank()) {
            this.titolo = titolo;
            this.data = validatoreData(data);
        } else {
            throw new EventoCreateException();
        }
        if (nPostiTotali > 0) {
            this.nPostiTotali = nPostiTotali;
        } else {
            throw new NumberFormatException();
        }
        this.nPostiPrenotati = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws EventoCreateException {
        if (!titolo.isBlank()) {
            this.titolo = titolo;
        } else {
            throw new EventoCreateException();
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) throws EventoCreateException, InvalidDateException {
        if (!data.isBlank()) {
            this.data = validatoreData(data);
        } else {
            throw new EventoCreateException();
        }
    }

    public int getnPostiTotali() {
        return nPostiTotali;
    }

    public int getnPostiPrenotati() {
        return nPostiPrenotati;
    }

    // restituisce true se data è valida, false se già passata; accetta formato dd/mm/yyyy
    public boolean comparatoreData(String date) {
        // formattatore
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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

    public String validatoreData(String input) throws InvalidDateException {
        String regex = "\\d{2}/\\d{2}/\\d{4}";  // validatore

        if(input.matches(regex)) {
            if (comparatoreData(input)) {
                return input;
            } else {
                throw new InvalidDateException();
            }
        } else {
            throw new InvalidDateException();
        }
    }

    public void prenota(int n) throws PrenotationException {
        if (comparatoreData(this.data) && (nPostiTotali - nPostiPrenotati) > 0 && (nPostiTotali - nPostiPrenotati) > n) {
            for (int i = 0; i < n; i++) {
                nPostiPrenotati++;
            }
        } else {
            throw new PrenotationException();
        }
    }

    public void disdici(int n) throws PrenotationException {
        if (comparatoreData(this.data) && nPostiPrenotati != 0) {
            for (int i = 0; i < n; i++) {
                nPostiPrenotati--;
            }
        } else {
            throw new PrenotationException();
        }
    }

    @Override
    public String toString() {
        return "Evento {" + data + " - " + titolo +'}';
    }
}
