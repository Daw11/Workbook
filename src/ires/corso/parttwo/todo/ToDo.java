package ires.corso.parttwo.todo;

import java.io.Serializable;

public class ToDo implements Serializable
{
    private long ID;
    private String titolo;
    private String descrizione;

    public ToDo(){
        ID = ToDoRepository.nextID();
    }

    public ToDo cloneForUpdate() {
        ToDo t = new ToDo();
        t.ID = ID;
        t.titolo = titolo;
        t.descrizione = descrizione;
        return t;
    }

    public String prettyPrint(){
        return String.format("ID: %d, titolo: %s", ID, titolo);
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
}
