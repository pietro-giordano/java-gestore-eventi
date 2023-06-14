package org.lessons.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    // metodo aggiungi evento
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    // metodo che restituisce numero eventi
    public int getNumeroEventi() {
        return eventi.size();
    }

    // metodo che svuota lista
    public void svuotaEventi() {
        eventi.clear();
    }

    // metodo che genera lista di eventi di una data
    public List<Evento> getEventiData(LocalDate data) {
        List<Evento> eventiData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().equals(data)) {
                eventiData.add(evento);
            }
        }
        return eventiData;
    }

    // metodo che ritorna stringhe data + titolo
    public void getDataTitoloEventi() {
        System.out.println("Titolo programma: " + getTitolo());
        for (Evento evento : eventi) {
            System.out.println(evento.getData() + " - " + evento.getTitolo());
        }
    }
}
