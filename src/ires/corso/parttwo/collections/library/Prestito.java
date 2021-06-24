package ires.corso.parttwo.collections.library;

import java.util.ArrayList;
import java.util.Iterator;

public class Prestito {
    private final Utente utente;
    private final ArrayList<Libro> libri;

    public Prestito( Utente utente, ArrayList<Libro> libri ) {
        this.utente = utente;
        this.libri = libri;
    }

    public Utente getUtente() {
        return utente;
    }

    public Iterator<Libro> getLibri(){
        return libri.iterator();
    }
}
