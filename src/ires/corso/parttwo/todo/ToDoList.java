package ires.corso.parttwo.todo;

import java.util.Comparator;
import java.util.List;

// GRUPPO 1:
public class ToDoList
{
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile

    private final static Comparator<ToDo> priorityComparator = new Comparator<ToDo>() {
        @Override
        public int compare(ToDo o1, ToDo o2) {
            return o1.getPriority().compareTo( o2.getPriority() );
        }
    };

    private final static Comparator<ToDo> dateComparator = new Comparator<ToDo>() {
        @Override
        public int compare(ToDo o1, ToDo o2) {
            return o1.getDataConsegna().compareTo( o2.getDataConsegna() );
        }
    };

    private final static Comparator<ToDo> stateComparator = new Comparator<ToDo>() {
        @Override
        public int compare(ToDo o1, ToDo o2) {
            return o1.getStato().compareTo( o2.getStato() );
        }
    };

    private static void showList( String msg, Comparator comparator ){
        ToDoApplication.display(msg);
        List<ToDo> sortedList = ToDoRepository.getToDoList();
        sortedList.sort( comparator );
        prettyPrint( sortedList );
    }

    public static void viewByPriority() {
        showList( "Lista ordinata per priorità: \n", priorityComparator );
    }

    public static void viewByDate() {
        showList( "Lista ordinata per data: \n", dateComparator );
    }

    public static void viewByState() {
        showList( "Lista ordinata per stato: \n", stateComparator );
    }

    private static void prettyPrint( List<ToDo> list ){
        for( ToDo t : list )
            ToDoApplication.display( t.prettyPrint() );
    }
}
