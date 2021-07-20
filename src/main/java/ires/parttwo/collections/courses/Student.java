package ires.parttwo.collections.courses;

public class Student {
    private final String nome;
    private final String cognome;
    private final String codiceStudente;

    public Student(String nome, String cognome, String codiceStudente) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceStudente = codiceStudente;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceStudente() {
        return codiceStudente;
    }
}
