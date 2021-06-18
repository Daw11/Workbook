package ires.corso.parttwo.firstclasses.cards;

public class Licantropo extends Personaggio {
    class FormaUmana extends Umano implements Combattente {
        @Override
        public String getForza() {
            return "Forza rimanente come licantropo umano: " + forza;
        }
    }

    class FormaMostro extends Mostro implements Azzannatore {
        @Override
        public String getForza() {
            return "Forza rimanente come licantropo mostro: " + forza;
        }
    }

    private Personaggio personaggio;

    public Licantropo( boolean luna ) {
        if( luna )
            personaggio = new FormaMostro();
        else
            personaggio = new FormaUmana();
    }

    @Override
    public String getForza() {
        return personaggio.getForza();
    }

    @Override
    public void attacca() {
        personaggio.attacca();
    }
}
