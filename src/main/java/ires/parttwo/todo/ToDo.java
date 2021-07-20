package ires.parttwo.todo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ToDo implements Serializable
{
    public enum Stato { DA_FARE, IN_ESECUZIONE, COMPLETATA, ANNULLATA };
    public enum Priority { ALTA, MEDIA, BASSA };

    public final static String dateFormat = "dd-MM-yyyy HH:mm";

    private long ID;
    private LocalDateTime dataCreazione;

    private String titolo;
    private String descrizione;
    private Stato stato;
    private Priority priority;
    private LocalDateTime dataConsegna;

    public ToDo(){
        ID = ToDoRepository.nextID();
        dataCreazione = LocalDateTime.now();
    }

    public ToDo cloneForUpdate() {
        ToDo t = new ToDo();
        t.ID = ID;
        t.dataCreazione = dataCreazione;
        t.titolo = titolo;
        t.descrizione = descrizione;
        t.stato = stato;
        t.priority = priority;
        t.dataConsegna = dataConsegna;
        return t;
    }

    public String prettyPrint(){
        return String.format(
                "ID: %d, titolo: %s, descrizione: %s, stato: %s, priorità: %s, data consegna: %s\n",
                ID, titolo, descrizione, stato.name(), priority.name(), formatDate( dataConsegna )
        );
    }

    public String exportString(){
        return String.format(
                "data creazione:%s\ntitolo:%s\ndescrizione:%s\nstato:%s\npriorità:%s\ndata consegna:%s\n",
                formatDate( dataCreazione ), titolo, descrizione, stato.name(), priority.name(), formatDate( dataConsegna )
        );
    }

    public static ToDo createFromString( List<String> s ){
        ToDo t = new ToDo();

        for( String action : s ){
            int separator = action.indexOf(":");
            String key = action.substring( 0, separator );
            String value = action.substring( separator + 1 );
            switch ( key ){
                case "data creazione": t.setDataCreazione( value ); break;
                case "titolo": t.setTitolo( value ); break;
                case "descrizione": t.setDescrizione( value ); break;
                case "stato": t.setStato( value ); break;
                case "priorità": t.setPriority( value ); break;
                case "data consegna": t.setDataConsegna( value ); break;
                default:
                    ToDoApplication.displayln("Errore, la chiave non è valida.");
            }
        }

        return t;
    }

    private static LocalDateTime getDateFromString( String s ){
        LocalDateTime ldt = null;
        try {
            ldt = LocalDateTime.parse(s, getDateFormatter());
        }
        catch ( DateTimeParseException e ){
            ToDoApplication.displayln("Errore durante l'importazione del file. La data inserita non è valida.");
        }

        return ldt;
    }

    public static DateTimeFormatter getDateFormatter(){
        return DateTimeFormatter.ofPattern( dateFormat );
    }

    public static String formatDate( LocalDateTime date ){
        return date.format( getDateFormatter() ).toString();
    }

    public long getID(){
        return ID;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setStato( String s ){
        this.stato = Stato.valueOf( s );
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setPriority( String s ){
        this.priority = Priority.valueOf( s );
    }

    public LocalDateTime getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(LocalDateTime data_consegna) {
        this.dataConsegna = data_consegna;
    }

    public void setDataConsegna(String s) {
        LocalDateTime ldt = getDateFromString( s );
        this.dataConsegna = ldt;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    private void setDataCreazione( LocalDateTime data_creazione ) {
        this.dataCreazione = data_creazione;
    }

    private void setDataCreazione( String s ) {
        LocalDateTime ldt = getDateFromString( s );
        this.dataCreazione = ldt;
    }
}
