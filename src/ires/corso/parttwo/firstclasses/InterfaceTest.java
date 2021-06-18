package ires.corso.parttwo.firstclasses;
import ires.corso.parttwo.firstclasses.cards.*;

public class InterfaceTest {
    public static void main(String[] args) {
        Eroe eroe = new Eroe();
        Vampiro vampiro = new Vampiro();
        Licantropo licantropo = new Licantropo( true );

        for( int i = 0; i < 3; i++ )
            eroe.attacca();
        vampiro.attacca();
        licantropo.attacca();

        System.out.println( eroe.getForza() );
        System.out.println( vampiro.getForza() );
        System.out.println( licantropo.getForza() );
    }
}
