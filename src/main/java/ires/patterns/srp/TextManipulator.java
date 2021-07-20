package ires.patterns.srp;

public class TextManipulator implements ITextManipulator {

    private String text;

    public TextManipulator(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void appendText(String newText) {
        this.text = this.text.concat(newText);
    }

    @Override
    public String findWordAndReplace(String word, String replWord) {
        if(this.text.contains(word)){
            this.text = this.text.replace(word, replWord);
        }
        return this.text;
    }

    @Override
    public void printText() {
        System.out.println(this.text);
    }

}
