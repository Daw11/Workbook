package ires.parttwo.collections.library;

public class Utente {
    private final String nome;
    private final String cognome;
    private final String id;

    public Utente(String nome, String cognome, String id) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getId() {
        return id;
    }
}
