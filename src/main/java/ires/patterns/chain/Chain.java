package ires.patterns.chain;

interface BankEmployee {
    void acceptPayment( int amount );
}

class Direttore implements BankEmployee {
    @Override
    public void acceptPayment( int amount ) {
        System.out.println("Pagamento accettato dal direttore.");
    }
}

class ViceDirettore implements BankEmployee {
    private BankEmployee superiore;

    public void setSuperiore(BankEmployee superiore) {
        this.superiore = superiore;
    }

    @Override
    public void acceptPayment( int amount ) {
        if( amount < 25000 )
            System.out.println("Pagamento accettato dal vice direttore.");
        else
            superiore.acceptPayment( amount );
    }
}

class Impiegato implements BankEmployee {
    private BankEmployee superiore;

    public void setSuperiore(BankEmployee superiore) {
        this.superiore = superiore;
    }

    @Override
    public void acceptPayment( int amount ) {
        if( amount < 10000 )
            System.out.println("Pagamento accettato da impiegato.");
        else
            superiore.acceptPayment( amount );
    }
}

public class Chain {
    public static void main(String[] args) {
        Impiegato i = new Impiegato();
        ViceDirettore vd = new ViceDirettore();
        Direttore d = new Direttore();
        i.setSuperiore(vd);
        vd.setSuperiore(d);

        i.acceptPayment(30000);
    }

}
