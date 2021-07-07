package ires.corso.test;

public class LibroManager {
    public static void avanzamentoLettura(){
        Applicazione.println("Inserisci l'ID del libro.");
        Applicazione.println("ID: ");
        Long ID = Applicazione.askForLong();
        if( !Biblioteca.has( ID ) ){
            Applicazione.println("Errore, il libro non esiste.");
            return;
        }
    }

    public static void giudizioPersonale(){
        Applicazione.println("Inserisci l'ID del libro.");
        Applicazione.println("ID: ");
        Long ID = Applicazione.askForLong();
        if( !Biblioteca.has( ID ) ){
            Applicazione.println("Errore, il libro non esiste.");
            return;
        }
    }
}
