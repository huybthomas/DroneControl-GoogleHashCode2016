package be.thevaultraiders.service;

import be.thevaultraiders.models.Drone;
import be.thevaultraiders.models.Map;
import be.thevaultraiders.models.Simulation;
import be.thevaultraiders.models.Warehouse;

import java.util.List;

/**
 * Created by Thomas on 11/02/2016.
 */
public class SimulatorCreator
{
    public Simulation createSimulation(String filename)
    {
        int i;
        TextFileReader reader = new TextFileReader();
        reader.parseFile(filename);

        //Create simulation model
        Simulation simulation = new Simulation(reader.getnCols(), reader.getnRows(), reader.gettDeadline());

        //Create drones
        for(i = 0; i < reader.getnDrones(); i++)
        {
            simulation.getMap().addDrone(new Drone(reader.getMaxLoad(), reader.getWarehouses()[0].getLocation().getDestX(), reader.getWarehouses()[0].getLocation().getDestY()));
        }

        //Add warehouses
        for(i = 0; i < reader.getnWarehouses(); i++)
        {
            simulation.getMap().addWarehouse(reader.getWarehouses()[i]);
        }

        //Add orders
        for(i = 0; i < reader.getnOrders(); i++)
        {
            simulation.addOrder(reader.getOrders()[i]);
        }

        return simulation;
    }
}
