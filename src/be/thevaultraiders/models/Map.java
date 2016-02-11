package be.thevaultraiders.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Map
{
    private int sizeX, sizeY;
    private List<Drone> drones;
    private List<Warehouse> warehouses;

    public Map(int sizeX, int sizeY)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.drones = new ArrayList<Drone>();
        this.warehouses = new ArrayList<Warehouse>();
    }

    public int getSizeX()
    {
        return sizeX;
    }

    public void setSizeX(int sizeX)
    {
        this.sizeX = sizeX;
    }

    public int getSizeY()
    {
        return sizeY;
    }

    public void setSizeY(int sizeY)
    {
        this.sizeY = sizeY;
    }

    public void addDrone(Drone drone)
    {
        drones.add(drone);
    }

    public void addWarehouse(Warehouse warehouse)
    {
        warehouses.add(warehouse);
    }

    public Drone getDrone(int number)
    {
        if(number > 0 && number < drones.size())
        {
            return drones.get(number);
        }
        else
        {
            return null;
        }
    }

    public Warehouse getWarehouse(int number)
    {
        if(number > 0 && number < warehouses.size())
        {
            return warehouses.get(number);
        }
        else
        {
            return null;
        }
    }
}
