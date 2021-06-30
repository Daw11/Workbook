package ires.corso.parttwo.todo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                ID, titolo, descrizione, stato.name(), priority.name(), dataConsegna.format( getDateFormatter() ).toString()
        );
    }

    public static DateTimeFormatter getDateFormatter(){
        return DateTimeFormatter.ofPattern( dateFormat );
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDateTime getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(LocalDateTime data_consegna) {
        this.dataConsegna = data_consegna;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }
}
