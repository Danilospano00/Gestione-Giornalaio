package org.corso.giornalaio;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Giornalaio {
    private AbbonamentoRiviste abbonamenti;

    public Giornalaio() {
        this.abbonamenti = new AbbonamentoRiviste();
    }

    public void stampaAbbonamenti() {
        for (int giorno = 1; giorno <= 7; giorno++) {
            System.out.println("Giorno : " + giorno);
            Iterator<Map.Entry<Cliente, Set<Rivista>>> iter = abbonamenti.getAbbonamenti().entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Cliente, Set<Rivista>> entry = iter.next();
                Iterator<Rivista> iteratorSetRivista = entry.getValue().iterator();
                while (iteratorSetRivista.hasNext()) {
                    Rivista rivistaCorrente = iteratorSetRivista.next();
                    if (rivistaCorrente.getGiornoDiUscita() == giorno ) {
                        System.out.println("Spedire al cliente: " + entry.getKey().getNomeCliente() + " la rivista "+rivistaCorrente.getNomeRivista());
                    }
                }

            }
        }
    }

    

    public AbbonamentoRiviste getListaAbbonamenti() {
        return abbonamenti;
    }

}
