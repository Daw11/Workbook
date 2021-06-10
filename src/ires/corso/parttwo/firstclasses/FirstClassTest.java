package ires.corso.parttwo.firstclasses;
import ires.corso.parttwo.firstclasses.Automobile;

public class FirstClassTest {
    public static void main(String[] args){
        Automobile car = new Automobile( "Fiat", true );
        car.setChilometri( 1000 );
        car.prettyPrint();

        Computer pc = Computer.assembleComputer("Windows", 16);
        pc.prettyPrint();
    }
}
