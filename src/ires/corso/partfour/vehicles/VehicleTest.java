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

        System.out.println("Tutti i veicoli:");
        VehicleRepository.getVehicleList().forEach( System.out::println );

        System.out.println("\nSolo camion:");
        VehicleRepository.getVehicleList(Vehicle.Type.TRUCK).forEach( System.out::println );

        VehicleRepository.delete(t1.getTarga());

        System.out.println("\nSolo camion 2:");
        VehicleRepository.getVehicleList(Vehicle.Type.TRUCK).forEach( System.out::println );

        vr.writeToFile( repositoryPath );
    }
}
