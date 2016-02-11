package be.thevaultraiders.models;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Drone
{
    private int maxPayload;
    private int locX, locY;

    public Drone(int maxPayload, int locX, int locY)
    {
        this.maxPayload = maxPayload;
        this.locX = locX;
        this.locY = locY;
    }

    public int getMaxPayload()
    {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload)
    {
        this.maxPayload = maxPayload;
    }

    public int getLocX()
    {
        return locX;
    }

    public void setLocX(int locX)
    {
        this.locX = locX;
    }

    public int getLocY()
    {
        return locY;
    }

    public void setLocY(int locY)
    {
        this.locY = locY;
    }
}
