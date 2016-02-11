package be.thevaultraiders.models;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Simulation
{
    private Map map;
    private int simulationTime;
    private int totalStepsDrones;

    public Simulation(int mapSizeX, int mapSizeY)
    {
        this.map = new Map(mapSizeX, mapSizeY);
        this.simulationTime = 0;
        this.totalStepsDrones = 0;
    }

    public void advanceSimulationTime(){
        this.simulationTime++;
    }

    public void addStep(){
        this.totalStepsDrones++;
    }

    public Map getMap()
    {
        return this.map;
    }

    public int getSimulationTime()
    {
        return this.simulationTime;
    }

    public int getTotalStepsDrones()
    {
        return this.totalStepsDrones;
    }
}
