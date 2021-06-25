package ires.corso.parttwo.collections.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Prestito {
    private final Utente utente;
    private final List<Libro> libri;

    public Prestito( Utente utente, List<Libro> libri ) {
        this.utente = utente;
        this.libri = new ArrayList<>( libri );
    }

    public Utente getUtente() {
        return utente;
    }

    public Iterator<Libro> getLibri(){
        return libri.iterator();
    }
}
