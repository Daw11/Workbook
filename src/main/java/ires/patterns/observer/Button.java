package ires.patterns.observer;

import java.util.HashSet;
import java.util.Set;

interface Observer {
    void update();
}

interface ObserverUser {
    void connect( Observer o );
    void disconnect( Observer o );
}

class ButtonObserver implements Observer {
    private final String name;

    public ButtonObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println( "Button clicked -> " + name );
    }
}

public class Button implements ObserverUser {
    Set<Observer> observers = new HashSet<>();

    public static void main(String[] args) {
        Button b = new Button();
        Observer o1 = new ButtonObserver("Observer 1");
        Observer o2 = new ButtonObserver("Observer 2");
        b.connect( o1 );
        b.connect( o2 );
        b.click();
        System.out.println("**********");
        b.disconnect( o1 );
        b.click();
    }

    public void click(){
        observers.forEach( Observer::update );
    }

    @Override
    public void connect( Observer o ){
        if( observers.contains( o ) )
            throw new RuntimeException( "Observer already connected" );
        observers.add( o );
    }

    @Override
    public void disconnect( Observer o ){
        if( !observers.contains( o ) )
            throw new RuntimeException( "Observer not connected" );
        observers.remove( o );
    }
}


