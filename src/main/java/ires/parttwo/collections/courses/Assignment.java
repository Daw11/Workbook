package ires.parttwo.collections.courses;

public class Assignment {
    private final String titolo;
    private final String descrizione;

    public Assignment(String titolo, String descrizione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
