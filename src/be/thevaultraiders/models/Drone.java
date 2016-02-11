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
    private List<Product> products;
    private boolean available;

    public Drone(int maxPayload, int locX, int locY)
    {
        this.maxPayload = maxPayload;
        this.location = new Location(locX, locY);
        this.products = new ArrayList<Product>();
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
