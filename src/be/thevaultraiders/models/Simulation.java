package be.thevaultraiders.models;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Simulation
{
    private Map map;

    public Simulation(int mapSizeX, int mapSizeY)
    {
        this.map = new Map(mapSizeX, mapSizeY);
    }

    public Map getMap()
    {
        return this.map;
    }
}
