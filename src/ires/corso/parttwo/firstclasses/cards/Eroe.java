package ires.corso.parttwo.firstclasses.cards;

public class Eroe extends Umano implements Combattente {
    @Override
    public String getForza() {
        return "Forza rimanente come eroe: " + forza;
    }
}
