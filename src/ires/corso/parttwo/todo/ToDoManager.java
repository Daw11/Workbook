package ires.corso.parttwo.todo;

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
        ToDoApplication.display("Vuoi creare questo ToDo? (s/n)\n");
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
        ToDoApplication.display("Vuoi applicare queste modifiche? (s/n)\n");
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
        if( !(isEdit && input.isEmpty()) )
            t.setTitolo( input );

        ToDoApplication.display("Descrizione:  ");
        input = ToDoApplication.askForString();
        if( !(isEdit && input.isEmpty()) )
            t.setDescrizione( input );

        ToDo.Stato stato = null;
        boolean valid;
        do {
            valid = true;
            ToDoApplication.display( "Stato (1: DA_FARE, 2: IN_ESECUZIONE, 3: COMPLETATA, 4: ANNULLATA): " );
            input = ToDoApplication.askForString();
            switch (input) {
                case "1":
                    stato = ToDo.Stato.DA_FARE;
                    break;
                case "2":
                    stato = ToDo.Stato.IN_ESECUZIONE;
                    break;
                case "3":
                    stato = ToDo.Stato.COMPLETATA;
                    break;
                case "4":
                    stato = ToDo.Stato.ANNULLATA;
                    break;
                case "":
                    if( isEdit ){
                        stato = t.getStato();
                        break;
                    }
                default:
                    ToDoApplication.display("Errore, lo stato non è valido, riprova.\n");
                    valid = false;
            }
        }while( !valid );
        t.setStato( stato );

        ToDo.Priority priority = null;
        do {
            valid = true;
            ToDoApplication.display( "Priorità (1: ALTA, 2: MEDIA, 3: BASSA): " );
            input = ToDoApplication.askForString();
            switch (input) {
                case "1":
                    priority = ToDo.Priority.ALTA;
                    break;
                case "2":
                    priority = ToDo.Priority.MEDIA;
                    break;
                case "3":
                    priority = ToDo.Priority.BASSA;
                    break;
                case "":
                    if( isEdit ){
                        priority = t.getPriority();
                        break;
                    }
                default:
                    ToDoApplication.display("Errore, la priorità non è valida, riprova.\n");
                    valid = false;
            }
        }while( !valid );
        t.setPriority( priority );

        ToDoApplication.display( "Data (" + ToDo.dateFormat + "): " );
        LocalDateTime date = ToDoApplication.askForDateTime( ToDo.getDateFormatter() );
        t.setDataConsegna( date );
    }
}
