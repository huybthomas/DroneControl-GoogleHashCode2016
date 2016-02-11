package be.thevaultraiders.terminal;

import java.util.Observable;

/**
 * Created by Thomas on 11/02/2016.
 */
public class TerminalObserver extends Observable
{
    public void clearChanged()
    {
        super.clearChanged();
    }

    public void setChanged()
    {
        super.setChanged();
    }
}
