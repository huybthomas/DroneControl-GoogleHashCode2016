package be.thevaultraiders.service;

import be.thevaultraiders.models.Drone;
import be.thevaultraiders.models.Simulation;
import be.thevaultraiders.models.Warehouse;

import java.util.Iterator;

/**
 * Created by Thomas on 11/02/2016.
 */
public class DroneService
{
    public DroneService(String filename)
    {
        SimulatorCreator creator = new SimulatorCreator();
        Simulation simulation = creator.createSimulation(filename);
        
        //Simulation loop
        //CODE VOOR SIMULATIE HIER, WERKEN MET model Simulation voor data

        //TODO open output file
        //TODO output data to outputFile

        //Divide all drones over warehouses
        int nDrones = simulation.getMap().getDrones().size();
        int nWarehouses = simulation.getMap().getWarehouses().size();
        int nDronesPerWarehouse = (int)Math.floor(nDrones/(double)nWarehouses);

        Iterator<Drone> droneIterator = simulation.getMap().getDrones().iterator();
        Iterator<Warehouse>  warehouseIterator = simulation.getMap().getWarehouses().iterator();
        while(warehouseIterator.hasNext()){
            Warehouse warehouse = warehouseIterator.next();
            for(int j=0; j<nDronesPerWarehouse; j++){
                Drone drone = droneIterator.next();
                drone.setDesignatedWarehouse(warehouse);
            }
        }
        while(droneIterator.hasNext()){
            Drone drone = droneIterator.next();
            Warehouse warehouse = warehouseIterator.next();
            drone.setDesignatedWarehouse(warehouse);
        }

        //Setup drones --> i.e. make them fly to the  warehouses
        droneIterator = simulation.getMap().getDrones().iterator();
        while(droneIterator.hasNext()){
            Drone drone = droneIterator.next();
            drone.returnHome();
            //TODO Print steps
        }

        //Main loop
        boolean notDone = false;
        while(!notDone){
            Iterator droneItr = simulation.getMap().getDrones().iterator();
            while(droneItr.hasNext()){
                Drone drone = (Drone)droneItr.next();
                //TODO Drone Logic && Order Logic
                drone.droneTick();
                simulation.addStep();
            }
            simulation.advanceSimulationTime();
        }
    }

    public int[] mergeSort(int[] data){
        int lenD = data.length;
        if(lenD<=1){
            return data;
        }
        else{
            int[] sorted = new int[lenD];
            int middle = lenD/2;
            int rem = lenD-middle;
            int[] L = new int[middle];
            int[] R = new int[rem];
            System.arraycopy(data, 0, L, 0, middle);
            System.arraycopy(data, middle, R, 0, rem);
            L = this.mergeSort(L);
            R = this.mergeSort(R);
            sorted = merge(L, R);
            return sorted;
        }
    }
    public int[] merge(int[] L, int[] R){
        int lenL = L.length;
        int lenR = R.length;
        int[] merged = new int[lenL+lenR];
        int i = 0;
        int j = 0;
        while(i<lenL||j<lenR){
            if(i<lenL & j<lenR){
                if(L[i]<=R[j]){
                    merged[i+j] = L[i];
                    i++;
                }
                else{
                    merged[i+j] = R[j];
                    j++;
                }
            }
            else if(i<lenL){
                merged[i+j] = L[i];
                i++;
            }
            else if(j<lenR){
                merged[i+j] = R[j];
                j++;
            }
        }
        return merged;
    }
}
