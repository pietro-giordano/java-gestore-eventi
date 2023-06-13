package org.lessons.java;

import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
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
}
