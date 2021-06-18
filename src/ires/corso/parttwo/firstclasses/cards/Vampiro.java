package ires.corso.parttwo.firstclasses.cards;

public class Vampiro extends Mostro implements Azzannatore {
    @Override
    public String getForza() {
        return "Forza rimanente come vampiro: " + forza;
    }
}
