package ires.parttwo.firstclasses.cards;

public interface Azzannatore extends Attacca {
    @Override
    default void attacca() {
        takeDamage( 2 );
    }
}
