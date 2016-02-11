package be.thevaultraiders.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevendecleene on 11/02/16.
 */
public class CustomerOrder {

    private boolean priority;
    private Location destination;
    private List<Product> reqProducts;

    public CustomerOrder(int destX, int destY) {
        this.destination = new Location(destX, destY);
        reqProducts = new ArrayList<>();
    }

    public boolean getPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
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

}
