package be.thevaultraiders.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Simulation
{
    private Map map;
    private List<CustomerOrder> orders;
    private int deadline;
    private int simulationTime;
    private int totalStepsDrones;

    public Simulation(int mapSizeX, int mapSizeY, int deadline)
    {
        this.map = new Map(mapSizeX, mapSizeY);
        this.deadline = deadline;
        this.orders = new ArrayList<CustomerOrder>();
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

    public int getDeadline()
    {
        return this.deadline;
    }

    public List<CustomerOrder> getOrders()
    {
        return this.orders;
    }

    public void addOrder(CustomerOrder order)
    {
        this.orders.add(order);
    }
}
