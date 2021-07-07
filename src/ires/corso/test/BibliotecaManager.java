package ires.corso.test;

import java.time.LocalDate;

public class BibliotecaManager {
    public static void creaLibro(){

    }

    private static void getibro( Libro l, boolean isEdit ){
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

        Applicazione.println("Data pubblicazione: ");
        LocalDate date = Applicazione.askForDate( isEdit );
        l.set_data_pubblicazione( date );
    }
}
