package org.lessons.java;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, String data, int nPostiTotali, String ora, BigDecimal prezzo) throws EventoCreateException, InvalidDateException, InvalidTimeException, InvalidPriceException {
        super(titolo, data, nPostiTotali);
        this.ora = oraFormattata(ora);
        this.prezzo = prezzoFormattato(prezzo);
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

    public LocalTime oraFormattata(String ora) throws InvalidTimeException {
        String regex = "\\d{2}:\\d{2}";  // validatore

        if(ora.matches(regex)) {
            return LocalTime.parse(ora);
        } else {
            throw new InvalidTimeException();
        }
    }

    public BigDecimal prezzoFormattato(BigDecimal prezzo) throws InvalidPriceException {
        if (prezzo instanceof BigDecimal) {
            return prezzo.setScale(2, RoundingMode.HALF_UP);
        } else {
            throw new InvalidPriceException();
        }
    }

    @Override
    public String toString() {
        return "Concerto { " + getData() + ora + " - " + getTitolo() + " - " + prezzo + "€ " + '}';
    }
}
