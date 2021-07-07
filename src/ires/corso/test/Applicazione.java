package ires.corso.test;

import ires.corso.test.menu.MenuBranch;
import ires.corso.test.menu.MenuItem;
import ires.corso.test.menu.MenuLeaf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Applicazione {
    private static MenuBranch main_menu;

    public static void main(String[] args) {
        final String save_file = "biblioteca.txt";

        Biblioteca.loadFromFile( save_file );

        printTitle();
        loadMainMenu();
        main_menu.run();

        Biblioteca.writeToFile( save_file );
    }

    public static void print( String msg ){
        System.out.print( msg );
    }

    public static void println( String msg ){
        System.out.println( msg );
    }

    public static void printTitle(){
        println("-------------------------------");
        println("-Biblioteca di Busterna Davide-");
        println("-------------------------------");
    }

    public static void loadMainMenu(){
        MenuLeaf visualizza = new MenuLeaf("a", "Visualizzazione dei volumi esistenti", Applicazione::mostraLibri );

        MenuBranch creaModificaElimina;
        MenuLeaf crea = new MenuLeaf("a", "Aggiunta di un volume", BibliotecaManager::creaLibro );
        MenuLeaf modifica = new MenuLeaf("b", "Modifica di un volume", BibliotecaManager::aggiornaLibro );
        MenuLeaf elimina = new MenuLeaf("c", "Eliminazione di un volume", BibliotecaManager::rimuoviLibro );
        creaModificaElimina = new MenuBranch("b", "Crea / Modifica / Elimina", Arrays.asList( crea, modifica, elimina ), "d", "Indietro");

        MenuLeaf avanzamento = new MenuLeaf("c", "Avanzamento lettura", LibroManager::avanzamentoLettura );
        MenuLeaf giudizio = new MenuLeaf("d", "Giudizio personale", LibroManager::giudizioPersonale );

        MenuLeaf export = new MenuLeaf("e", "Export su file", BibliotecaExport::exportFile );

       MenuLeaf uscita = new MenuLeaf("f", "Uscita", Applicazione::closeProgram );

        List<MenuItem> main_menu_options = Arrays.asList( visualizza, creaModificaElimina, avanzamento, giudizio, export, uscita );
        main_menu = new MenuBranch("MainMenu", "Menu principale", main_menu_options);
    }

    private static void mostraLibri(){
        List<Libro> libri = Biblioteca.getLibri();
        if( libri.size() == 0 )
            println("Al momento non ci sono libri nella biblioteca.");
        else
            libri.stream().sorted(Comparator.comparing( Libro::get_titolo )).map( Libro::prettyPrint ).forEach( Applicazione::println );
    }

    private static void closeProgram(){
        println("Sei sicuro di voler uscire? (s/n)");
        String input = askForInput();
        if( input.toLowerCase().equals( "s" ) )
            main_menu.set_exit( true );
    }

    private static String askForInput(){
        Scanner in = new Scanner( System.in );
        return in.nextLine();
    }

    public static String askForString(){
        return askForInput().trim();
    }

    public static boolean isNumber( String str ){
        return str.matches( "\\d+" );
    }

    public static int askForInt(){
        int result = -1;
        boolean valid = false;

        do {
            String input = askForInput();
            if( isNumber( input ) ){
                result = Integer.parseInt( input );
                valid = true;
            }
            else {
                Applicazione.println("Errore: non hai inserito un numero, riprova.");
                valid = false;
            }
        }while( !valid );

        return result;
    }

    public static long askForLong(){
        long result = -1;
        boolean valid = false;
        do {
            String input = askForString();
            if( isNumber( input ) ) {
                valid = true;
                result = Long.parseLong( input );
            }
            else
                println("Errore: non hai inserito un numero, riprova");
        }while(!valid);

        return result;
    }

    public static LocalDate askForDate( boolean allowBlank ){
        LocalDate result = null;
        boolean valid = false;
        do {
            String str = askForString();
            try {
                result = LocalDate.parse(str, DateTimeFormatter.ofPattern( Libro.date_format ));
            }
            catch ( DateTimeParseException e ){
                if( allowBlank && str.isEmpty() )
                    valid = true;
                else {
                    Applicazione.println("Errore, la stringa inserita non è una data, riprova.");
                    continue;
                }
            }
            valid = true;
        }while(!valid);

        return result;
    }
}
