package ires.corso.parttwo.todo;

import java.io.Serializable;

public class ToDo implements Serializable
{
    private long nextInt = 0;

    private final long ID;
    private String titolo;

    // ...costruttore con ID incrementale...
    public ToDo(){
        ID = ++nextInt;
    }

    public ToDo cloneForUpdate() {
        // fabbrica una copia esatta del To-Do (compreso l'ID)
        return null;
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
}
