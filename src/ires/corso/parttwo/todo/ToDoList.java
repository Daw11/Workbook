package ires.corso.parttwo.todo;

import jdk.nashorn.internal.objects.annotations.Function;

import java.util.Collections;
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

    private static int compareByPriority(ToDo o1, ToDo o2){ return o1.getPriority().compareTo( o2.getPriority() ); }
    private static int compareByDate(ToDo o1, ToDo o2){ return o1.getDataConsegna().compareTo( o2.getDataConsegna() ); }
    private static int compareByState(ToDo o1, ToDo o2){ return o1.getStato().compareTo( o2.getStato() ); }

    private static void showList( String msg, Comparator<ToDo> comparator ){
        ToDoApplication.display(msg);
        List<ToDo> sortedList = ToDoRepository.getToDoList();1
        sortedList.sort( comparator );
        prettyPrint( sortedList );
    }

    public static void viewByPriority() {
        showList( "Lista ordinata per priorità: \n", ToDoList::compareByPriority );
    }

    public static void viewByDate() {
        showList( "Lista ordinata per data: \n", ToDoList::compareByDate );
    }

    public static void viewByState() {
        showList( "Lista ordinata per stato: \n", ToDoList::compareByState );
    }

    private static void prettyPrint( List<ToDo> list ){
        list.stream().map( ToDo::prettyPrint ).forEach( ToDoApplication::display );
    }
}
