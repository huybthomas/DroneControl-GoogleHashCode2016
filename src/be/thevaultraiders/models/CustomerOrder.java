package be.thevaultraiders.models;

import be.thevaultraiders.util.Calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevendecleene on 11/02/16.
 */
public class CustomerOrder {

    private int destX, destY;
    private List<Product> reqProducts;
    private int totalOrderWeight;

    private int priority;
    private Warehouse closestWarehouse;

    public CustomerOrder(int destX, int destY) {
        this.destX = destX;
        this.destY = destY;
        reqProducts = new ArrayList<>();
        totalOrderWeight = 0;
    }

    public int getDestX() {
        return destX;
    }

    public void setDestX(int destX) {
        this.destX = destX;
    }

    public int getDestY() {
        return destY;
    }

    public void setDestY(int destY) {
        this.destY = destY;
    }

    public void addProduct(Product product) {
        this.reqProducts.add(product);
        this.totalOrderWeight += product.getPayload();
    }

    public List<Product> getReqProducts() {
        return reqProducts;
    }

    public int getTotalOrderWeight() {
        return totalOrderWeight;
    }

    public void setTotalOrderWeight(int totalOrderWeight) {
        this.totalOrderWeight = totalOrderWeight;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Warehouse getClosestWarehouse() {
        return closestWarehouse;
    }

    public void setClosestWarehouse(Warehouse closestWarehouse) {
        this.closestWarehouse = closestWarehouse;
    }

    public void calculatePriority(List<Warehouse> warehouses) {

        double optimalDistance = 1.0 * Integer.MAX_VALUE;
        Warehouse optimalWarehouse = null;

        for(Warehouse warehouse : warehouses) {
            double distance = Calculator.calculateDistance(destX, destY, warehouse.getLocation().getDestX(), warehouse.getLocation().getDestY());
            if(distance < priority) {
                optimalDistance = distance;
                optimalWarehouse = warehouse;
            }
        }

        priority = (int) Math.round(optimalDistance);
        closestWarehouse = optimalWarehouse;

        closestWarehouse.placeOrder(this);
    }

}
