package ires.corso.parttwo.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// GRUPPO 3/4:
public class ToDoApplication
{
    // 1. Deserializza il repository da file (carica i dati dell'ultimo salvataggio)
    //    creando una classe Repository
    // 2. Gestione del MENU principale con un loop e due switch
    // 3. In corrispondenza di una scelta dell'utente (ramo dello switch) chiama
    //    le classi necessarie per svolgere l'azione
    // 4. Chiede conferma e serializza in uscita
    // 5. Fornisce anche i metodi della classe "lettore" di quiz... askForInput , display

    private static ToDoRepository repository;

    public static void main(String[] args) {
        final String repositoryPath = "todos.txt";

        repository = ToDoRepository.loadFromFile( repositoryPath );
        printTitle();
        mainMenu();
        repository.writeToFile( repositoryPath );
    }

    public static void display( String msg ){
        System.out.print( msg );
    }

    private static String askForInput(){
        Scanner in = new Scanner( System.in );
        return in.nextLine();
    }

    public static String askForString(){
        return askForInput().trim();
    }

    public static int askForInt(){
        int result = -1;
        boolean valid = false;

        do {
            String input = askForInput();
            if( isInteger( input ) ){
                result = Integer.parseInt( input );
                valid = true;
            }
            else {
                display("Errore: non hai inserito un numero, riprova.\n");
                valid = false;
            }
        }while( !valid );

        return result;
    }

    public static int askForInt(int from, int to){
        int result = -1;
        boolean valid = false;

        do {
            int i = askForInt();
            if( intInRange( i, from, to ) ){
                result = i;
                valid = true;
            }
            else {
                display("Errore: non hai inserito un numero valido, riprova.\n");
                valid = false;
            }
        }while( !valid );

        return result;
    }


    public static boolean intInRange( int i, int from, int to ){
        boolean valid = from <= i && i <= to;
        if( !valid )
            display("Errore: il numero non è valido.\n");
        return valid;
    }

    public static long askForLong(){
        long result = -1;
        boolean valid = false;
        do {
            String input = ToDoApplication.askForString();
            if( input.matches( "\\d+") ) {
                valid = true;
                result = Long.parseLong( input );
            }
            else
                ToDoApplication.display("Errore: non hai inserito un numero, riprova\n");
        }while(!valid);

        return result;
    }

    public static boolean isInteger( String str ){
        return str.matches( "\\d+" );
    }

    public static LocalDateTime askForDateTime( DateTimeFormatter dtf, boolean allowBlank ){
        LocalDateTime result = null;
        boolean valid = false;
        do {
            String str = askForString();
            try {
                result = LocalDateTime.parse(str, dtf);
            }
            catch ( DateTimeParseException e ){
                if( allowBlank && str.isEmpty() )
                    valid = true;
                else {
                    display("Errore, la stringa inserita non è una data, riprova.\n");
                    continue;
                }
            }
            valid = true;
        }while(!valid);

        return result;
    }

    public static void printTitle(){
        display( "------------------------\n" );
        display( "------ToDo Manager------\n" );
        display( "------------------------\n\n" );
    }

    public static void mainMenu(){
        boolean quit = false;
        do{
            display("1. Visualizza, 2. Aggiungi, Rimuovi, Modifica, 3. Import/Export, 4. Uscita\n");
            int input = askForInt(1, 4);
            switch( input ) {
                case 1: visualizzaMenu(); break;
                case 2: editMenu(); break;
                case 3: importExportMenu(); break;
                default: quit = true; break;
            }
        }while( !quit );
    }

    public static void visualizzaMenu(){
        boolean quit = false;
        do {
            display("1. Per priorità, 2. Per data, 3. Per stato, 4. Indietro\n");
            int input = askForInt(1, 4);
            switch ( input ){
                case 1: ToDoList.viewByPriority(); break;
                case 2: ToDoList.viewByDate(); break;
                case 3: ToDoList.viewByState(); break;
                default: quit = true; break;
            }
        }while(!quit);
    }

    public static void editMenu(){
        boolean quit = false;
        do{
            display("1. Aggiungi, 2. Rimuovi, 3. Modifica, 4. Indietro\n");
            int input = askForInt(1,4);
            switch ( input ){
                case 1: ToDoManager.createNewToDo(); break;
                case 2: ToDoManager.removeTodo(); break;
                case 3: ToDoManager.updateToDo(); break;
                default: quit = true; break;
            }
        }while(!quit);
    }

    public static void importExportMenu(){
        boolean quit = false;
        do{
            display("1. Export su file, 2. Import da file, 3. Indietro\n");
            int input = askForInt(1,3);
            switch ( input ){
                case 1: ToDoImportExport.exportFile(); break;
                case 2: ToDoImportExport.importFile(); break;
                default: quit = true; break;
            }
        }while(!quit);
    }
}
