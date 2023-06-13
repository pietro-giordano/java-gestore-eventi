package org.lessons.java;

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

    public Integer nPositivo(int n) {
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
}
