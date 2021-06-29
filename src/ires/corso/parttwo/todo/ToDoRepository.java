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

    private ToDoRepository(){}

    // Serializzabile con la funzione writeObject()
    public static ToDoRepository loadFromFile(String fileName) {
        readFromFile( fileName );
        if( _repository == null )
            _repository = new ToDoRepository();
        return _repository;
    }

    public static ToDoRepository getToDoRepository() {
        return _repository;
    }

    public void delete(Long ID) {
        _data.remove( ID );
    };

    public void add(ToDo t) {
        long ID = t.getID();
        _data.put( ID, t );
    }

    public void update(ToDo t) {
        long ID = t.getID();
        _data.put( ID, t );
    }

    public List<ToDo> getToDoList() {
        return new ArrayList<ToDo>( _data.values() );
    }

    public static void readFromFile(String fileName){
        try
        {
            FileInputStream file = new FileInputStream(fileName);
           if( file.available() == 0 )
               return;

           ObjectInputStream in = new ObjectInputStream(file);
            _repository = (ToDoRepository) in.readObject();
           in.close();
           file.close();
        }
        catch(IOException ex) {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    public static void writeToFile(String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject( _repository );
            out.close();
            file.close();
        }
        catch(IOException ex) {
            System.out.println("Errore nella scrittura su file");
        }
    }
}
