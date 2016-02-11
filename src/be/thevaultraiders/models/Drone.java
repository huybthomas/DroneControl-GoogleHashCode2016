package be.thevaultraiders.models;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Drone
{
    private int maxPayload;
    private Location location;

    public Drone(int maxPayload, int locX, int locY)
    {
        this.maxPayload = maxPayload;
        this.location = new Location(locX, locY);
    }

    public int getMaxPayload()
    {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload)
    {
        this.maxPayload = maxPayload;
    }

    public Location getLocation()
    {
        return this.location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }
}
