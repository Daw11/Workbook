package ires.corso.parttwo.firstclasses.cards;

public interface Combattente extends Attacca {
    @Override
    default void attacca() {
        takeDamage( 3 );
    }
}
