package ires.corso.parttwo.todo;

// GRUPPO 2:
public class ToDoManager
{
    // Classe responsabile per le operazioni sull'insieme dei TO-DO:
    // - metodi per creazione nuovo TO-DO
    // - metodi per la modifica, la rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // - ha al suo interno funzioni di controllo sull'input utente

    public static void createNewToDo() {
        ToDo t = new ToDo();
        askForTodo( t, false );
        ToDoApplication.display( t.prettyPrint() );
        ToDoApplication.display("\nVuoi creare questo ToDo? (s/n)\n");
        String input = ToDoApplication.askForString();
        if( input.toLowerCase().equals("s") ) {
            ToDoRepository.add(t);
            ToDoApplication.display("Il ToDo è stato aggiunto.\n");
        }
    }

    public static void updateToDo() {
        ToDoApplication.display("Inserisci l'ID del ToDo da modificare.\n");
        long ID = ToDoApplication.askForLong();
        if( !ToDoRepository.has( ID ) ){
            ToDoApplication.display("Errore, il ToDo non esiste.\n\n");
            return;
        }
        ToDo original = ToDoRepository.getToDo( ID );
        ToDoApplication.display( original.prettyPrint() );
        ToDo copy = original.cloneForUpdate();
        askForTodo( copy, true );
        ToDoApplication.display( copy.prettyPrint() );
        ToDoApplication.display("\nVuoi applicare queste modifiche? (s/n)\n");
        String input = ToDoApplication.askForString();
        if( input.toLowerCase().equals("s") ) {
            ToDoRepository.add(copy);
            ToDoApplication.display("Il ToDo è stato aggiornato.\n");
        }
    }

    public static void removeTodo(){
        ToDoApplication.display("Inserisci l'ID del ToDo da eliminare.\n");
        ToDoApplication.display("ID: ");
        Long ID = ToDoApplication.askForLong();
        if( !ToDoRepository.has( ID ) ){
            ToDoApplication.display("Errore, il ToDo non esiste.\n\n");
            return;
        }
        ToDo t = ToDoRepository.getToDo( ID );
        ToDoApplication.display( t.prettyPrint() );
        ToDoApplication.display("Sei sicuro di voler eliminare questo ToDo? (s,n)");
        String input = ToDoApplication.askForString();
        if( !input.toLowerCase().equals("s") )
            return;
        ToDoRepository.delete( ID );
        ToDoApplication.display( "Il ToDo è stato eliminato.\n\n" );
    }

    private static void askForTodo( ToDo t, boolean isEdit ){
        String input;
        ToDoApplication.display("\nInserisci i dati:\n");

        ToDoApplication.display("Titolo: ");
        input = ToDoApplication.askForString();
        if( !(isEdit && input.trim().isEmpty()) )
            t.setTitolo( input );

        ToDoApplication.display("Descrizione:  ");
        input = ToDoApplication.askForString();
        if( !(isEdit && input.trim().isEmpty()) )
            t.setDescrizione( input );
    }
}
