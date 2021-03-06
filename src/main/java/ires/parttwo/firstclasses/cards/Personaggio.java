package ires.parttwo.firstclasses.cards;

abstract public class Personaggio implements Attacca {
    protected int forza;

    abstract public String getForza();

    protected void setForza(int forza) {
        this.forza = forza;
    }

    @Override
    public void takeDamage( int damage ){
        forza -= damage;
    }
}
