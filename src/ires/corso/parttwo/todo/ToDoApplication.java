package ires.corso.parttwo.todo;

import ires.corso.parttwo.todo.menu.ToDoMenuBranch;
import ires.corso.parttwo.todo.menu.ToDoMenuItem;
import ires.corso.parttwo.todo.menu.ToDoMenuLeaf;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
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
        ToDoMenuBranch menu = createMenu();
        menu.run();
        repository.writeToFile( repositoryPath );
    }

    public static void display( String msg ){
        System.out.print( msg );
    }
    public static void displayln( String msg ){ System.out.println( msg ); }

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
                displayln("Errore: non hai inserito un numero, riprova.");
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
                displayln("Errore: non hai inserito un numero valido, riprova.");
                valid = false;
            }
        }while( !valid );

        return result;
    }


    public static boolean intInRange( int i, int from, int to ){
        boolean valid = from <= i && i <= to;
        if( !valid )
            displayln("Errore: il numero non è valido.");
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
                ToDoApplication.displayln("Errore: non hai inserito un numero, riprova");
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
                    displayln("Errore, la stringa inserita non è una data, riprova.");
                    continue;
                }
            }
            valid = true;
        }while(!valid);

        return result;
    }

    public static void printTitle(){
        displayln( "------------------------" );
        displayln( "------ToDo Manager------" );
        displayln( "------------------------\n" );
    }

    private static ToDoMenuBranch createMenu(){
        ToDoMenuLeaf byPriority = new ToDoMenuLeaf("1", "Per priorità", ToDoList::viewByPriority );
        ToDoMenuLeaf byDate = new ToDoMenuLeaf("2", "Per data", ToDoList::viewByDate );
        ToDoMenuLeaf byState = new ToDoMenuLeaf("3", "Per stato", ToDoList::viewByState );
        ToDoMenuBranch visualizzaMenu = new ToDoMenuBranch("1", "Visualizza", Arrays.asList( byPriority, byDate, byState ));

        ToDoMenuLeaf addToDo = new ToDoMenuLeaf("1", "Aggiungi", ToDoManager::createNewToDo );
        ToDoMenuLeaf removeToDo = new ToDoMenuLeaf("2", "Rimuovi", ToDoManager::removeTodo );
        ToDoMenuLeaf editToDo = new ToDoMenuLeaf("3", "Modifica", ToDoManager::updateToDo );
        ToDoMenuBranch editMenu = new ToDoMenuBranch("2", "Aggiungi, Rimuovi, Modifica", Arrays.asList(addToDo, removeToDo, editToDo));

        ToDoMenuLeaf exportToDo = new ToDoMenuLeaf("1", "Export su file", ToDoImportExport::exportFile );
        ToDoMenuLeaf importToDo = new ToDoMenuLeaf("2", "Import da file", ToDoImportExport::importFile );
        ToDoMenuBranch importExportMenu = new ToDoMenuBranch("3", "Import/Export", Arrays.asList( exportToDo, importToDo ));

        ToDoMenuBranch mainMenu = new ToDoMenuBranch("MainMenu", "Menu Principale", Arrays.asList( visualizzaMenu, editMenu, importExportMenu ));
        mainMenu.setExitMessage("Esci");
        return mainMenu;
    }
}
