package ires.test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private Giudizio _giudizio;
    private int _avanzamento_lettura;

    public Libro(){
        _ID = Biblioteca.nextID();
    }

    public Libro cloneForUpdate() {
        Libro l = new Libro();
        l._ID = _ID;
        l._titolo = _titolo;
        l._autore = _autore;
        l._sinossi = _sinossi;
        l._isbn = _isbn;
        l._data_pubblicazione = _data_pubblicazione;
        l._genere = _genere;
        l._giudizio = _giudizio;
        l._avanzamento_lettura = _avanzamento_lettura;
        return l;
    }

    public String prettyPrint(){
        return String.format(
                "ID: %s\ntitolo: %s\nautore: %s\nsinossi: %s\nisbn: %s\ndata pubblicazione: %s\ngenere: %s\ngiudizio: %s\navanzamento lettura: %s\n",
                _ID, _titolo, _autore, _sinossi, _isbn, formattedDataPubblicazione(), _genere.name(), prettyPrintGiudizio(), _avanzamento_lettura
        );
    }

    public String exportablePrint(){
        return String.format(
                "ID: %s\nTITOLO: %s\nAUTORE: %s\nSINOSSI: %s\nISBN: %s\nDATA_PUBBLICAZIONE: %s\nGENERE: %s\nGIUDIZIO: %s\nAVANZAMENTO_LETTURA: %s",
                _ID, _titolo, _autore, _sinossi, _isbn, formattedDataPubblicazione(), _genere.name(), prettyPrintGiudizio(), _avanzamento_lettura
        );
    }

    public String formattedDataPubblicazione(){
        return  _data_pubblicazione.format( DateTimeFormatter.ofPattern( date_format ) ).toString();
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

    public Giudizio get_giudizio() {
        return _giudizio;
    }

    private String prettyPrintGiudizio(){
        if( _giudizio == null )
            return "";
        return _giudizio.toString();
    }

    public void set_giudizio(Giudizio _giudizio) {
        this._giudizio = _giudizio;
    }

    public int get_avanzamento_lettura() {
        return _avanzamento_lettura;
    }

    public void set_avanzamento_lettura(int _avanzamento_lettura) {
        this._avanzamento_lettura = _avanzamento_lettura;
    }
}
