package ires.vehicles;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    public enum Type { CAR, TRUCK, MOTORBIKE };

    private String _targa;
    protected Type _type;

    public Vehicle(String targa){
        _targa = targa;
    }

    public final String getTarga(){
        return _targa;
    }

    public final Type getType(){
        return _type;
    }

    @Override
    public String toString(){
        return String.format( "Targa: %s, Tipo: %s", getTarga(), getType());
    }
}

