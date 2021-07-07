package ires.corso.test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Biblioteca implements Serializable {
    private static Biblioteca _repository = null;
    Map<Long, Libro> _data = new HashMap<>();
    private long nextID = 0;

    private Biblioteca(){}

    public static Biblioteca loadFromFile(String fileName) {
        readFromFile( fileName );
        if( _repository == null )
            _repository = new Biblioteca();
        return _repository;
    }

    public static Biblioteca getToDoRepository() {
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

    public static void add(Libro t) {
        long ID = t.getID();
        _repository._data.put( ID, t );
    }

    public static void update(Libro t) {
        long ID = t.getID();
        _repository._data.put( ID, t );
    }

    public static Libro getLibro(long ID){
        return _repository._data.get( ID );
    }

    public static List<Libro> getLibri() {
        return new ArrayList<Libro>( _repository._data.values() );
    }

    public static void readFromFile(String fileName){
        File f = new File(fileName);
        if( !f.exists() )
            return;

        try(
                FileInputStream fileInputStream = new FileInputStream( f );
                ObjectInputStream in = new ObjectInputStream(fileInputStream))
        {
            _repository = (Biblioteca) in.readObject();
        }
        catch(IOException ex) {
            Applicazione.println("Errore di tipo IOException durante la lettura da file.");
        }
        catch(ClassNotFoundException ex) {
            Applicazione.println("Errore di tipo ClassNotFoundException durante la lettura da file.");
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
            Applicazione.println("Errore di tipo IOException durante la scrittura su file.");
        }
    }
}
