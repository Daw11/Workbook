package ires.parttwo.collections.library;

public class Libro {
    private final String titolo;
    private final String autore;
    private final String data;
    private final String pubblicazione;
    private final int num_pagine;
    private final int num_volumi;
    private final int num_capitoli;

    public Libro(String titolo, String autore, String data, String pubblicazione, int num_pagine, int num_volumi, int num_capitoli) {
        this.titolo = titolo;
        this.autore = autore;
        this.data = data;
        this.pubblicazione = pubblicazione;
        this.num_pagine = num_pagine;
        this.num_volumi = num_volumi;
        this.num_capitoli = num_capitoli;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getData() {
        return data;
    }

    public String getPubblicazione() {
        return pubblicazione;
    }

    public int getNum_pagine() {
        return num_pagine;
    }

    public int getNum_volumi() {
        return num_volumi;
    }

    public int getNum_capitoli() {
        return num_capitoli;
    }
}
