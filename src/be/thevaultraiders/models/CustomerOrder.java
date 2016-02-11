package be.thevaultraiders.models;

import be.thevaultraiders.util.Calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevendecleene on 11/02/16.
 */
public class CustomerOrder {

    private int priority;
    private Warehouse closestWarehouse;

    private Location destination;
    private List<Product> reqProducts;

    public CustomerOrder(int destX, int destY) {
        this.destination = new Location(destX, destY);
        reqProducts = new ArrayList<>();
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Location getLocation() {
        return destination;
    }

    public void setLocation(Location destination) {
        this.destination = destination;
    }

    public void addProduct(Product product) {
        this.reqProducts.add(product);
    }

    public List<Product> getReqProducts() {
        return reqProducts;
    }

    public void calculatePriority(List<Warehouse> warehouses) {
        double optimalDistance = Integer.MAX_VALUE;
        Warehouse optimalWarehouse = null;
        for(Warehouse warehouse : warehouses) {
            double distance = Calculator.calculateDistance(destination.getDestX(), destination.getDestY(), warehouse.getLocation().getDestX(), warehouse.getLocation().getDestY());
            if(distance < priority) {
                optimalDistance = distance;
                optimalWarehouse = warehouse;
            }
        }
        priority = (int) Math.round(optimalDistance);
        closestWarehouse = optimalWarehouse;
    }

}
