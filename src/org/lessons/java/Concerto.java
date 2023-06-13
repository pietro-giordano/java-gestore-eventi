package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, String data, int nPostiTotali, String ora, BigDecimal prezzo) throws EventoCreateException, InvalidDateException {
        super(titolo, data, nPostiTotali);
        this.ora = LocalTime.parse(ora);
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public void oraFormattata(String ora) {

    }

    @Override
    public String toString() {
        return "Concerto {" + getData() + ora + " - " + getTitolo() + " - " + prezzo + '}';
    }
}
