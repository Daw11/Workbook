package ires.corso.parttwo.todo.menu;

import ires.corso.parttwo.todo.ToDo;
import ires.corso.parttwo.todo.ToDoApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

// OPZIONE: contiene altri elementi
public class ToDoMenuBranch extends ToDoMenuItem {
    private List<ToDoMenuItem> _options = new ArrayList<>();
    private boolean _exit;
    private final String _defaultExitMessage = "Indietro";

    // Public constructor
    public ToDoMenuBranch(String ID, String title, List<ToDoMenuItem> options) {
        super(ID, title);
        _options.addAll( options );
        String exitID = String.valueOf( _options.size() + 1 );
        initExit( exitID, _defaultExitMessage );
    }

    public ToDoMenuBranch(String ID, String title, List<ToDoMenuItem> options, String exitID, String exitMessage) {
        super(ID, title);
        _options.addAll( options );
        if( exitID == null )
            exitID = String.valueOf( _options.size() + 1 );
        initExit( exitID, exitMessage );
    }

    private void initExit( String exitID, String exitMessage){
        ToDoMenuLeaf exitLeaf = new ToDoMenuLeaf( exitID, exitMessage, () -> _exit = true );
        _options.add( exitLeaf );
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);

        _exit = false;
        do {
            printContent();
            String choice = in.nextLine();
            Optional<ToDoMenuItem> selected = _options.stream().filter( o -> o.getID().equals( choice ) ).findFirst();
            if( selected.isPresent() )
                selected.get().run();
            else
                ToDoApplication.displayln( "L'opzione che hai selezionato non è valida." );
        }while( !_exit );
    }

    private void printContent() {
        ToDoApplication.displayln( getTitle() );
        _options.stream().map( ToDoMenuItem::toString ).forEach( ToDoApplication::displayln );
    }
}
