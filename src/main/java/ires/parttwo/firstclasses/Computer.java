package ires.parttwo.firstclasses;

public class Computer {
    private String os;
    private int ram;
    private boolean aggiornato;

    public static Computer assembleComputer(String os, int ram){
        return new Computer(os, ram);
    }

    private Computer(String os, int ram){
        this.os = os;
        this.ram = ram;
        this.aggiornato = false;
    }

    public void prettyPrint(){
        String result = String.format("Questo computer usa %s come sistema operativo, ha %d GB di RAM e", os, ram);
        result += aggiornato ? "d è già aggiornato." : " va aggiornato.";
        System.out.println(result);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public boolean isAggiornato() {
        return aggiornato;
    }

    public void setAggiornato(boolean aggiornato) {
        this.aggiornato = aggiornato;
    }
}
