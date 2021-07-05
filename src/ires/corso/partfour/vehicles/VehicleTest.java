package ires.corso.partfour.vehicles;

import ires.corso.parttwo.todo.ToDoRepository;

import java.util.Arrays;
import java.util.List;

public class VehicleTest {
    public static void main(String[] args) {
        final String repositoryPath = "vehicles.txt";
        VehicleRepository vr = VehicleRepository.loadFromFile( repositoryPath );

        System.out.println("Tutti i veicoli:");
        VehicleRepository.getVehicleList().forEach( System.out::println );

        System.out.println("\nSolo camion:");
        VehicleRepository.getVehicleList(Vehicle.Type.TRUCK).forEach( System.out::println );

        vr.writeToFile( repositoryPath );
    }
}
