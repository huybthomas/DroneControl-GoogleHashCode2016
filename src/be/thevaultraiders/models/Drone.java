package be.thevaultraiders.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Drone
{
    private int maxPayload;
    private Location location;
    private Warehouse designatedWarehouse;
    private List<Product> products;
    private List<Order> orders;
    private int flightTime;

    public Drone(int maxPayload, int locX, int locY)
    {
        this.maxPayload = maxPayload;
        this.location = new Location(locX, locY);
        this.products = new ArrayList<Product>();
        this.orders = new ArrayList<Order>();
    }

    public int getMaxPayload()
    {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload)
    {
        this.maxPayload = maxPayload;
    }

    public Location getLocation()
    {
        return this.location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public boolean loadProduct(Product product)
    {
        if(this.getCurrentLoad() + product.getPayload() <= this.maxPayload)
        {
            this.products.add(product);
            //Sort product for shortest possible flight time
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getCurrentLoad()
    {
        int currentLoad = 0;

        for(int i = 0; i < this.products.size(); i++)
        {
            currentLoad = this.products.get(i).getPayload();
        }

        return currentLoad;
    }

    public Product unloadNextProduct()
    {
        Iterator<Product> it = products.iterator();
        Product product;

        if(it.hasNext())
        {
            product = it.next();
            it.remove();

            return product;
        }
        else
        {
            //No products on board
            return null;
        }
    }

    private void flyTo(Location location){
        int distX = this.location.getDestX()-location.getDestX();
        int distY = this.location.getDestY()-location.getDestY();
        int sq = distX^2+distY^2;
        double dist = Math.sqrt(sq);
        flightTime=(int)Math.ceil(dist);
    }

    public void droneTick(){
        if(products.isEmpty() && flightTime <= 0){
            //this.flyTo()                  //Fly to nearest warehouse
        }else if(flightTime <=0 && !products.isEmpty()){
            this.unloadNextProduct();        //Unload Next product
            //this.flyTo()                  //fly to next order
        }else{
            flightTime--;
        }
    }

    public void returnHome(){
        this.flyTo(this.designatedWarehouse.getLocation());
    }

    public Warehouse getDesignatedWarehouse() {
        return designatedWarehouse;
    }

    public void setDesignatedWarehouse(Warehouse designatedWarehouse) {
        this.designatedWarehouse = designatedWarehouse;
    }
}
