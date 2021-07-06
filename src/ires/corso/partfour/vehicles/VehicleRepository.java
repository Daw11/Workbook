package ires.corso.partfour.vehicles;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleRepository implements Serializable {

    private static VehicleRepository _repository = null;
    private Map<String, Vehicle> _data = new HashMap<>();

    private VehicleRepository() {
    }

    public static VehicleRepository loadFromFile(String fileName) {
        readFromFile(fileName);
        if (_repository == null)
            _repository = new VehicleRepository();
        return _repository;
    }

    public static VehicleRepository getVehicleRepository() {
        return _repository;
    }

    public static boolean has(long ID) {
        return _repository._data.containsKey(ID);
    }

    public static void delete(String targa) {
        _repository._data.remove(targa);
    }

    public static void clear() {
        _repository._data.clear();
    }

    public static void add(Vehicle t) {
        String targa = t.getTarga();
        _repository._data.put(targa, t);
    }

    public static void swap(Vehicle t, String originalTarga){
        add( t );
        delete( originalTarga );
    }

    public static void update(Vehicle t) {
        String ID = t.getTarga();
        _repository._data.put(ID, t);
    }

    public static Vehicle getVehicle(String targa) {
        return _repository._data.get(targa);
    }

    public static List<Vehicle> getVehicleList() {
        return new ArrayList<Vehicle>(_repository._data.values());
    }

    public static List<Vehicle> getVehicleList( Vehicle.Type type ){
        List<Vehicle> all_vehicles = getVehicleList();
        if( type == null )
            return all_vehicles;
        return all_vehicles.stream().filter( v ->v.getType() == type ).collect(Collectors.toList());
    }

    public static void readFromFile(String fileName) {
        try (
                FileInputStream file = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(file)
        ) {
            _repository = (VehicleRepository) in.readObject();
        } catch (IOException ex) {
            System.out.println("IOException is caught.");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught.");
        }
    }

    public static void writeToFile(String fileName) {
        try (
                FileOutputStream file = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(file)
        ) {
            out.writeObject(_repository);
        } catch (IOException ex) {
            System.out.println("Errore nella scrittura su file.");
        }
    }
}