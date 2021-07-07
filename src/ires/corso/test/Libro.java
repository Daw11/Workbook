package ires.corso.test;

import java.io.Serializable;
import java.time.LocalDate;

public class Libro implements Serializable {
    public enum Genere { HORROR, FANTASY, GIALLO, STORICO, POESIA }
    public enum Giudizio { PESSIMO, BASSO, MEDIO, ALTO, OTTIMO }

    public static final String date_format = "dd-MM-yyyy";

    private long _ID;
    private String _titolo;
    private String _autore;
    private String _sinossi;
    private String _isbn;
    private LocalDate _data_pubblicazione;
    private Genere _genere;
    private int _avanzamento_lettura;

    public Libro(){
        _ID = Biblioteca.nextID();
    }

    public long getID(){
        return _ID;
    }

    public String get_titolo() {
        return _titolo;
    }

    public void set_titolo(String _titolo) {
        this._titolo = _titolo;
    }

    public String get_autore() {
        return _autore;
    }

    public void set_autore(String _autore) {
        this._autore = _autore;
    }

    public String get_sinossi() {
        return _sinossi;
    }

    public void set_sinossi(String _sinossi) {
        this._sinossi = _sinossi;
    }

    public String get_isbn() {
        return _isbn;
    }

    public void set_isbn(String _isbn) {
        this._isbn = _isbn;
    }

    public LocalDate get_data_pubblicazione() {
        return _data_pubblicazione;
    }

    public void set_data_pubblicazione(LocalDate _data_pubblicazione) {
        this._data_pubblicazione = _data_pubblicazione;
    }

    public Genere get_genere() {
        return _genere;
    }

    public void set_genere(Genere _genere) {
        this._genere = _genere;
    }

    public int get_avanzamento_lettura() {
        return _avanzamento_lettura;
    }

    public void set_avanzamento_lettura(int _avanzamento_lettura) {
        this._avanzamento_lettura = _avanzamento_lettura;
    }
}
