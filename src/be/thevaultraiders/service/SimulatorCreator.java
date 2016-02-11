package be.thevaultraiders.service;

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
        TextFileReader reader = new TextFileReader();
        reader.parseFile(filename);


    }
}
