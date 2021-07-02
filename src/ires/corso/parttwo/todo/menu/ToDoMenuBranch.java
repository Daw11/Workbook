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

    // Public constructor
    public ToDoMenuBranch(String ID, String title, List<ToDoMenuItem> options) {
        super(ID, title);
        _options.addAll(options);
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);

        boolean exit = false;
        do {
            printContent();
            String choice = in.nextLine();
            Optional<ToDoMenuItem> selected = _options.stream().filter( o -> o.getID().equals( choice ) ).findFirst();
            if( selected.isPresent() )
                selected.get().run();
            else
                exit = true;
        }while( !exit );
    }

    private void printContent() {
        ToDoApplication.display( getTitle() + "\n" );
        _options.stream().map( ToDoMenuItem::toString ).forEach( ToDoApplication::displayln );
    }
}
