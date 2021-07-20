package ires.parttwo.firstclasses;

public class Automobile {
    private String marca;
    private int chilometri;
    private boolean nuova;

    public Automobile(String marca, boolean nuova){
        this.nuova = nuova;
        this.marca = marca;
        this.chilometri = 0;
    }

    public void prettyPrint(){
        String result = String.format("Questa macchina ha come marca %s, ", marca);
        result += nuova ? "è nuova, " : "è usata, ";
        result += String.format("e ha già percorso %d chilometri.", chilometri);
        System.out.println(result);
    }

    public int getChilometri() {
        return chilometri;
    }

    public void setChilometri(int chilometri) {
        this.chilometri = chilometri;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isNuova() {
        return nuova;
    }

    public void setNuova(boolean nuova) {
        this.nuova = nuova;
    }
}
