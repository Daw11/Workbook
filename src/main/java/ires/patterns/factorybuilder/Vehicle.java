package ires.patterns.factorybuilder;

public interface Vehicle {
}

class Car implements Vehicle {

}

class Motorbike implements Vehicle {

}

class Truck implements Vehicle {}

class VehicleBuilder {
    public static Vehicle build( int nRuote ){
        switch ( nRuote ){
            case 2: return new Motorbike();
            case 4: return new Car();
            case 6: return new Truck();
            default:
                System.out.println( "Errore" );
                return null;
        }
    }
}