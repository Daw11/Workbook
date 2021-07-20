package ires.test.menu;

public class MenuLeaf extends MenuItem
{
    private final Runnable _action;

    public MenuLeaf(String ID, String title, Runnable action) {
        super(ID, title);
        _action = action;
    }

    @Override
    public void run() {
        _action.run();
    }
}