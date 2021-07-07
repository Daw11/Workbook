package ires.corso.test;

import java.time.LocalDate;
import java.util.Arrays;

public class BibliotecaManager {
    public static void creaLibro(){
        Libro l = new Libro();
        getDatiLibro( l, false );
        Applicazione.println( l.prettyPrint() );
        Applicazione.println("Vuoi aggiungere questo libro alla biblioteca? (s/n)");
        String input = Applicazione.askForString();
        if( input.toLowerCase().equals("s") ) {
            Biblioteca.add( l );
            Applicazione.println("Il libro è stato aggiunto.");
        }
    }

    public static void aggiornaLibro(){
        Applicazione.println("Inserisci l'ID del libro da modificare.");
        long ID = Applicazione.askForLong();
        if( !Biblioteca.has( ID ) ){
            Applicazione.println("Errore, il libro non esiste.");
            return;
        }
        Libro original = Biblioteca.getLibro( ID );
        Applicazione.println( original.prettyPrint() );
        Libro copy = original.cloneForUpdate();
        getDatiLibro( copy, true );
        Applicazione.println( copy.prettyPrint() );
        Applicazione.println("Vuoi applicare queste modifiche? (s/n)");
        String input = Applicazione.askForString();
        if( input.toLowerCase().equals("s") ) {
            Biblioteca.add( copy );
            Applicazione.println("Il libro è stato aggiornato.");
        }
    }

    public static void rimuoviLibro(){
        Applicazione.println("Inserisci l'ID del libro da eliminare.");
        Applicazione.println("ID: ");
        Long ID = Applicazione.askForLong();
        if( !Biblioteca.has( ID ) ){
            Applicazione.println("Errore, il libro non esiste.");
            return;
        }
        Libro l = Biblioteca.getLibro( ID );
        Applicazione.println( l.prettyPrint() );
        Applicazione.println("Sei sicuro di voler eliminare questo libro? (s,n): ");
        String input = Applicazione.askForString();
        if( !input.toLowerCase().equals("s") )
            return;
        Biblioteca.delete( ID );
        Applicazione.println( "Il libro è stato eliminato." );
    }

    private static void getDatiLibro( Libro l, boolean isEdit ){
        String input;

        Applicazione.println("Titolo: ");
        input = Applicazione.askForString();
        l.set_titolo( input );

        Applicazione.println("Autore: ");
        input = Applicazione.askForString();
        l.set_autore( input );

        Applicazione.println("Sinossi: ");
        input = Applicazione.askForString();
        l.set_sinossi( input );

        Applicazione.println("Codice ISBN: ");
        input = Applicazione.askForString();
        l.set_isbn( input );

        Applicazione.println("Data pubblicazione (" + Libro.date_format + ")");
        LocalDate date = Applicazione.askForDate( isEdit );
        l.set_data_pubblicazione( date );

        boolean valid;
        Libro.Genere genere = null;
        do {
            valid = true;
            Applicazione.print("Genere ( ");
            Arrays.asList(Libro.Genere.values()).forEach(e -> Applicazione.print(e.toString() + " "));
            Applicazione.println(")");
            input = Applicazione.askForString();
            try{
                genere = Libro.Genere.valueOf( input );
            } catch ( IllegalArgumentException e ){
                valid = false;
                Applicazione.println("Errore, il genere non è valido.");
            }
        } while( !valid );
        l.set_genere( genere );
    }
}
