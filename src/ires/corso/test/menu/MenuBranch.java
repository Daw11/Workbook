package ires.corso.test.menu;

import ires.corso.test.Applicazione;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuBranch extends MenuItem {
    private List<MenuItem> _options = new ArrayList<>();
    private boolean _exit;
    private final String _defaultExitMessage = "Indietro";

    public MenuBranch( String ID, String title, List<MenuItem> options ) {
        super(ID, title);
        _options.addAll( options );
    }

    public MenuBranch(String ID, String title, List<MenuItem> options, String chiudiID, String chiudiTitolo ){
        super(ID, title);
        _options.addAll( options );
        MenuLeaf exitLeaf = new MenuLeaf( chiudiID, chiudiTitolo, () -> _exit = true );
        _options.add( exitLeaf );
    }

    @Override
    public void run() {
        _exit = false;
        do {
            printContent();
            String choice = Applicazione.askForString();
            Optional<MenuItem> selected = _options.stream().filter(o -> o.getID().equals( choice ) ).findFirst();
            if( selected.isPresent() )
                selected.get().run();
            else
                Applicazione.println( "L'opzione che hai selezionato non è valida." );
        }while( !_exit );
    }

    private void printContent() {
        Applicazione.println( "\n" + getTitle() );
        _options.stream().map( MenuItem::toString ).forEach( Applicazione::println );
    }

    public void set_exit(boolean _exit) {
        this._exit = _exit;
    }
}
