package ires.corso.test;

import java.time.LocalDate;
import java.util.Arrays;

public class BibliotecaManager {
    public static void creaLibro(){
        Libro l = new Libro();
        Applicazione.println("Inserisci i dati del nuovo libro.");
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
        Applicazione.println("Inserisci i nuovi dati per il libro, lascia una linea vuota se vuoi mantenere quelli precedenti.");
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
        if( !(isEdit && input.isEmpty()) )
            l.set_titolo( input );

        Applicazione.println("Autore: ");
        input = Applicazione.askForString();
        if( !(isEdit && input.isEmpty()) )
            l.set_autore( input );

        Applicazione.println("Sinossi: ");
        input = Applicazione.askForString();
        if( !(isEdit && input.isEmpty()) )
            l.set_sinossi( input );

        Applicazione.println("Codice ISBN: ");
        input = Applicazione.askForString();
        if( !(isEdit && input.isEmpty()) )
            l.set_isbn( input );

        Applicazione.println("Data pubblicazione (" + Libro.date_format + ")");
        LocalDate date = Applicazione.askForDate( isEdit );
        if( date != null )
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
                if( !(isEdit && input.isEmpty()) )
                    genere = Libro.Genere.valueOf( input );
            } catch ( IllegalArgumentException e ){
                valid = false;
                Applicazione.println("Errore, il genere non è valido.");
            }
        } while( !valid );
        l.set_genere( genere );
    }
}
