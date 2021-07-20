package ires.patterns.srp;

public interface ITextManipulator {
    String getText();
    void appendText(String newText);
    String findWordAndReplace(String word, String replWord);
    void printText();
}
