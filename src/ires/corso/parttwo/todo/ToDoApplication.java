package ires.corso.parttwo.todo;

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

    public static void main(String[] args) {
        printTitle();

        boolean quit = false;
        do {
            printMainMenu();
            int input = askForInt(1, 4);
            switch( input ){
                case 1:
                    display("1");
                    break;
                case 2:
                    display("2");
                    break;
                case 3:
                    display("3");
                    break;
                default:
                    quit = true;
                    break;
            }


        }while( !quit );
    }

    public static void display( String msg ){
        System.out.print( msg );
    }

    public static String askForInput(){
        Scanner in = new Scanner( System.in );
        return in.nextLine();
    }

    public static int askForInt(int from, int to){
        int result = -1;
        boolean valid = true;

        do {
            String input = askForInput();
            if( isInteger( input ) ){
                result = Integer.parseInt( input );
                if( intInRange( result, from, to ) )
                    valid = true;
            }
            else {
                display("Errore: non hai inserito un numero, riprova.\n");
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

    public static boolean isInteger( String str ){
        return str.matches( "\\d+" );
    }

    public static void printTitle(){
        display( "------------------------\n" );
        display( "------ToDo Manager------\n" );
        display( "------------------------\n\n" );
    }

    public static void printMainMenu(){
        display("1. Visualizza, 2. Aggiungi, Rimuovi, Modifica, 3. Import/Export, 4. Uscita\n");
    }
}
