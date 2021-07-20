package ires.patterns.srp;

public class TextManipulatorMain {

    public static void main(String[] args) {
        ITextManipulator tm = new TextManipulator("My String");
        tm.appendText(" ciao");
        tm.findWordAndReplace("ciao", "addio");
        tm.printText();
    }

}
