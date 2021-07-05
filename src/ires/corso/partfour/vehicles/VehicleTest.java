package ires.corso.partfour.vehicles;

import ires.corso.parttwo.todo.ToDoRepository;

import java.util.Arrays;
import java.util.List;

public class VehicleTest {
    public static void main(String[] args) {
        final String repositoryPath = "vehicles.txt";
        VehicleRepository vr = VehicleRepository.loadFromFile( repositoryPath );

        Car c = new Car("ABC3434");
        Truck t1 = new Truck("123456");
        Truck t2 = new Truck("65343342");
        Motorbike m1 = new Motorbike("13425435");

        List<Vehicle> vehicles = Arrays.asList( c, t1, t2, m1 );
        vehicles.forEach( VehicleRepository::add );

        printList(null, "Tutti i veicoli:");

        printList(Vehicle.Type.TRUCK, "Solo camion:");

        VehicleRepository.delete(t1.getTarga());

        printList(Vehicle.Type.TRUCK, "Solo camion 2:");

        vr.writeToFile( repositoryPath );
    }

    private static void printList(Vehicle.Type type, String msg){
        System.out.println("\n" + msg);
        VehicleRepository.getVehicleList(type).forEach( System.out::println );
    }
}
