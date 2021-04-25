package org.corso.giornalaio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbbonamentoRiviste {

    private Map<Cliente, Set<Rivista>> abbonamenti = new HashMap<Cliente, Set<Rivista>>();

    public AbbonamentoRiviste() {
    }

    public Map<Cliente, Set<Rivista>> getAbbonamenti() {
        return abbonamenti;
    }

    public void assegnaAbbonamenti(Cliente cliente, Rivista rivista) throws RivistaNonEsistente, ClienteNonEsistente {
        if (rivista == null) {
            throw new RivistaNonEsistente();
        }
        if (cliente == null) {
            throw new ClienteNonEsistente();
        }
        Set<Rivista> riviste = abbonamenti.get(cliente);
        if (riviste == null) {
            riviste = new HashSet<Rivista>();
        }
        riviste.add(rivista);
        abbonamenti.put(cliente, riviste);
    }

    public void disdiciAbbonamenti(Cliente cliente, Rivista rivista) throws RivistaNonEsistente, ClienteNonEsistente {
        if (rivista == null) {
            throw new RivistaNonEsistente();
        }
        if (cliente == null) {
            throw new ClienteNonEsistente();
        }
        abbonamenti.get(cliente).remove(rivista);

    }

}
