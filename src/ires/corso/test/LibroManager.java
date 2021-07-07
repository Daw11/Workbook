package ires.corso.test;

import java.util.Arrays;

public class LibroManager {
    public static void avanzamentoLettura(){
        Applicazione.println("Inserisci l'ID del libro.");
        Applicazione.println("ID: ");
        Long ID = Applicazione.askForLong();
        if( !Biblioteca.has( ID ) ){
            Applicazione.println("Errore, il libro non esiste.");
            return;
        }
        Libro l = Biblioteca.getLibro( ID );
        Applicazione.println( l.prettyPrint() );

        if( l.get_avanzamento_lettura() == 100 ) {
            Applicazione.println("Errore, non puoi modificare l'avanzamento perchè è già a 100.");
            return;
        }

        Applicazione.println("Inserisci il nuovo valore per l'avanzamento della lettura di questo libro: ");

        int avanzamento = Applicazione.askForInt();
        if( avanzamento < 0 || avanzamento > 100 ) {
            Applicazione.println("Errore, il valore inserito non è un avanzamento valido.");
            return;
        }

        l.set_avanzamento_lettura( avanzamento );
        Applicazione.println("L'avanzamento è stato aggiornato.");
    }

    public static void giudizioPersonale(){
        Applicazione.println("Inserisci l'ID del libro.");
        Applicazione.println("ID: ");
        Long ID = Applicazione.askForLong();
        if( !Biblioteca.has( ID ) ){
            Applicazione.println("Errore, il libro non esiste.");
            return;
        }

        Libro l = Biblioteca.getLibro( ID );
        Applicazione.println( l.prettyPrint() );

        if( l.get_avanzamento_lettura() < 100 ) {
            Applicazione.println("Errore, non puoi modificare il giudizio di questo libro, lo devi prima completare.");
            return;
        }

        boolean valid;
        Libro.Giudizio giudizio = null;
        do {
            valid = true;
            Applicazione.print("Inserisci il tuo giudizio sul libro ( ");
            Arrays.asList(Libro.Giudizio.values()).forEach(e -> Applicazione.print(e.toString() + " "));
            Applicazione.println(")");
            String input = Applicazione.askForString();
            try{
                giudizio = Libro.Giudizio.valueOf( input );
            } catch ( IllegalArgumentException e ){
                valid = false;
                Applicazione.println("Errore, il giudizio non è valido.");
            }
        } while( !valid );

        l.set_giudizio( giudizio );
        Applicazione.println("Il giudizio è stato aggiornato.");
    }
}
