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
    private String _exitMessage = "Indietro";

    // Public constructor
    public ToDoMenuBranch(String ID, String title, List<ToDoMenuItem> options) {
        super(ID, title);
        _options.addAll(options);
    }

    public void setExitMessage(String exitMessage) {
        this._exitMessage = exitMessage;
    }

    private Stream<ToDoMenuItem> optionsWithExit(){
        String ID = String.valueOf( _options.size() + 1 );
        ToDoMenuLeaf exitLeaf = new ToDoMenuLeaf( ID, _exitMessage, () -> _exit = true );
        return Stream.concat( _options.stream(), Stream.of( exitLeaf ) );
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);

        _exit = false;
        do {
            printContent();
            String choice = in.nextLine();
            Optional<ToDoMenuItem> selected = optionsWithExit().filter( o -> o.getID().equals( choice ) ).findFirst();
            if( selected.isPresent() )
                selected.get().run();
            else
                ToDoApplication.displayln( "L'opzione che hai selezionato non è valida." );
        }while( !_exit );
    }

    private void printContent() {
        ToDoApplication.displayln( getTitle() );
        optionsWithExit().map( ToDoMenuItem::toString ).forEach( ToDoApplication::displayln );
    }
}
