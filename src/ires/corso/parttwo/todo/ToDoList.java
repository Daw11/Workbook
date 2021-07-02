package ires.corso.parttwo.todo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

// GRUPPO 1:
public class ToDoList
{
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile


    private static void showList( String msg, Function<ToDo, Comparable> field ){
        ToDoApplication.display(msg);
        List<ToDo> sortedList = ToDoRepository.getToDoList();
        Comparator<ToDo> comparator = Comparator.comparing( field );
        sortedList.sort( comparator );
        prettyPrint( sortedList );
    }

    public static void viewByPriority() {
        showList( "Lista ordinata per priorità: \n", ToDo::getPriority );
    }

    public static void viewByDate() {
        showList( "Lista ordinata per data: \n", ToDo::getDataConsegna );
    }

    public static void viewByState() {
        showList( "Lista ordinata per stato: \n", ToDo::getStato );
    }

    private static void prettyPrint( List<ToDo> list ){
        list.stream().map( ToDo::prettyPrint ).forEach( ToDoApplication::display );
    }
}
