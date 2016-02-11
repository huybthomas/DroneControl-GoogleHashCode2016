package be.thevaultraiders.service;

import be.thevaultraiders.models.Drone;
import be.thevaultraiders.models.Simulation;

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

        //Divide all drones over warehouses

        //Main loop
        boolean notDone = false;
        while(!notDone){
            Iterator droneItr = simulation.getMap().getDrones().iterator();
            while(droneItr.hasNext()){
                Drone drone = (Drone)droneItr.next();
                if(drone.isAvailable()){
                     //Assign Order


                    drone.setAvailable(false);
                }
                else{
                    drone.flightTick();
                }
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
