package ires.parttwo.todo;

import java.time.LocalDateTime;

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
        ToDoApplication.displayln("Vuoi creare questo ToDo? (s/n)");
        String input = ToDoApplication.askForString();
        if( input.toLowerCase().equals("s") ) {
            ToDoRepository.add(t);
            ToDoApplication.displayln("Il ToDo è stato aggiunto.\n");
        }
    }

    public static void updateToDo() {
        ToDoApplication.displayln("Inserisci l'ID del ToDo da modificare.");
        long ID = ToDoApplication.askForLong();
        if( !ToDoRepository.has( ID ) ){
            ToDoApplication.displayln("Errore, il ToDo non esiste.\n");
            return;
        }
        ToDo original = ToDoRepository.getToDo( ID );
        ToDoApplication.display( original.prettyPrint() );
        ToDo copy = original.cloneForUpdate();
        askForTodo( copy, true );
        ToDoApplication.display( copy.prettyPrint() );
        ToDoApplication.displayln("Vuoi applicare queste modifiche? (s/n)");
        String input = ToDoApplication.askForString();
        if( input.toLowerCase().equals("s") ) {
            ToDoRepository.add(copy);
            ToDoApplication.displayln("Il ToDo è stato aggiornato.\n");
        }
    }

    public static void removeTodo(){
        ToDoApplication.displayln("Inserisci l'ID del ToDo da eliminare.");
        ToDoApplication.display("ID: ");
        Long ID = ToDoApplication.askForLong();
        if( !ToDoRepository.has( ID ) ){
            ToDoApplication.displayln("Errore, il ToDo non esiste.\n");
            return;
        }
        ToDo t = ToDoRepository.getToDo( ID );
        ToDoApplication.display( t.prettyPrint() );
        ToDoApplication.displayln("Sei sicuro di voler eliminare questo ToDo? (s,n): ");
        String input = ToDoApplication.askForString();
        if( !input.toLowerCase().equals("s") )
            return;
        ToDoRepository.delete( ID );
        ToDoApplication.displayln( "Il ToDo è stato eliminato.\n" );
    }

    private static void askForTodo( ToDo t, boolean isEdit ){
        String input;
        if( isEdit )
            ToDoApplication.displayln("Inserisci i dati, lascia il campo vuoto se vuoi mantenere gli originali:");
        else
            ToDoApplication.displayln("Inserisci i dati:");

        ToDoApplication.display("Titolo: ");
        input = ToDoApplication.askForString();
        if( !(isEdit && input.isEmpty()) )
            t.setTitolo( input );

        ToDoApplication.display("Descrizione:  ");
        input = ToDoApplication.askForString();
        if( !(isEdit && input.isEmpty()) )
            t.setDescrizione( input );

        ToDo.Stato stato = askForStato( t, isEdit );
        t.setStato( stato );

        ToDo.Priority priority = askForPriority( t, isEdit );
        t.setPriority( priority );

        ToDoApplication.display( "Data (" + ToDo.dateFormat + "): " );
        LocalDateTime date = ToDoApplication.askForDateTime( ToDo.getDateFormatter(), isEdit );
        if( date != null )
            t.setDataConsegna( date );
    }

    private static ToDo.Stato askForStato( ToDo t, boolean isEdit ){
        ToDo.Stato stato = null;
        boolean valid;
        do {
            valid = true;
            ToDoApplication.display( "Stato (1: DA_FARE, 2: IN_ESECUZIONE, 3: COMPLETATA, 4: ANNULLATA): " );
            String input = ToDoApplication.askForString();
            switch (input) {
                case "1": stato = ToDo.Stato.DA_FARE; break;
                case "2": stato = ToDo.Stato.IN_ESECUZIONE; break;
                case "3": stato = ToDo.Stato.COMPLETATA; break;
                case "4": stato = ToDo.Stato.ANNULLATA; break;
                case "":
                    if( isEdit ){
                        stato = t.getStato();
                        break;
                    }
                default:
                    ToDoApplication.displayln("Errore, lo stato non è valido, riprova.");
                    valid = false;
            }
        }while( !valid );

        return stato;
    }

    private static ToDo.Priority askForPriority( ToDo t, boolean isEdit ){
        ToDo.Priority priority = null;
        boolean valid;
        do {
            valid = true;
            ToDoApplication.display( "Priorità (1: ALTA, 2: MEDIA, 3: BASSA): " );
            String input = ToDoApplication.askForString();
            switch (input) {
                case "1": priority = ToDo.Priority.ALTA; break;
                case "2": priority = ToDo.Priority.MEDIA; break;
                case "3": priority = ToDo.Priority.BASSA; break;
                case "":
                    if( isEdit ){
                        priority = t.getPriority();
                        break;
                    }
                default:
                    ToDoApplication.displayln("Errore, la priorità non è valida, riprova.");
                    valid = false;
            }
        }while( !valid );

        return priority;
    }
}
