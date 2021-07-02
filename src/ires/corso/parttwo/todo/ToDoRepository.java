package ires.corso.parttwo.todo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// GRUPPO 4:
public class ToDoRepository implements Serializable
{
    /* GESTORE DELL'ARCHIVIO DEI TO-DO == DATABASE */

    // Contiene una HashMap di tutti i TO-DO a sistema:
    // - implementa il metodo di salvataggio su file
    // - implementa il metodo di caricamento da file
    // - metodi per individuare, aggiungere, eliminare un TO-DO
    // - restituisce una copia di tutti i TO-DO come ArrayList, da
    //   usare per le visualizzazioni di ToDoList

    private static ToDoRepository _repository = null;
    Map<Long, ToDo> _data = new HashMap<>();
    private long nextID = 0;

    private ToDoRepository(){}

    public static ToDoRepository loadFromFile(String fileName) {
        readFromFile( fileName );
        if( _repository == null )
            _repository = new ToDoRepository();
        return _repository;
    }

    public static ToDoRepository getToDoRepository() {
        return _repository;
    }

    public static long nextID(){
        return ++_repository.nextID;
    }

    public static boolean has(long ID){
        return _repository._data.containsKey( ID );
    }

    public static void delete(long ID) {
       _repository._data.remove( ID );
    }

    public static void clear() { _repository._data.clear(); }

    public static void add(ToDo t) {
        long ID = t.getID();
        _repository._data.put( ID, t );
    }

    public static void update(ToDo t) {
        long ID = t.getID();
        _repository._data.put( ID, t );
    }

    public static ToDo getToDo(long ID){
        return _repository._data.get( ID );
    }

    public static List<ToDo> getToDoList() {
        return new ArrayList<ToDo>( _repository._data.values() );
    }

    public static void readFromFile(String fileName){
        try(
                FileInputStream file = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(file)
        )
        {
           _repository = (ToDoRepository) in.readObject();
        }
        catch(IOException ex) {
            ToDoApplication.displayln("IOException is caught.");
        }
        catch(ClassNotFoundException ex) {
            ToDoApplication.displayln("ClassNotFoundException is caught.");
        }
    }

    public static void writeToFile(String fileName) {
        try (
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file)
        ){
            out.writeObject( _repository );
        }
        catch(IOException ex) {
            ToDoApplication.displayln("Errore nella scrittura su file.");
        }
    }
}
