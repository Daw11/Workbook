package ires.corso.test;

import ires.corso.test.menu.MenuBranch;
import ires.corso.test.menu.MenuLeaf;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static ires.corso.parttwo.todo.ToDoApplication.displayln;

public class Applicazione {
    public static void main(String[] args) {
        final String save_file = "biblioteca.txt";

        Biblioteca.loadFromFile( save_file );

        printTitle();
        MenuBranch menu = createMenu();
        menu.run();

        Biblioteca.writeToFile( save_file );
    }

    public static void println( String msg ){
        System.out.println( msg );
    }

    public static void printTitle(){
        println("-------------------------------");
        println("-Biblioteca di Busterna Davide-");
        println("-------------------------------");
    }

    public static MenuBranch createMenu(){
        MenuLeaf visualizza = new MenuLeaf("a", "Visualizzazione dei volumi esistenti", () -> Biblioteca.getLibri().sort(Comparator.comparing( Libro::get_titolo )) );
        MenuBranch main_menu = new MenuBranch("MainMenu", "Menu principale", Arrays.asList( visualizza ), false);
        return main_menu;
    }

    private static String askForInput(){
        Scanner in = new Scanner( System.in );
        return in.nextLine();
    }

    public static String askForString(){
        return askForInput().trim();
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
                    displayln("Errore, la stringa inserita non è una data, riprova.");
                    continue;
                }
            }
            valid = true;
        }while(!valid);

        return result;
    }
}
