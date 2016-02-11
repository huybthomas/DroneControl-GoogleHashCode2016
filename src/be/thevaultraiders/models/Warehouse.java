package be.thevaultraiders.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Warehouse
{
    private Location location;
    private List<List<Product>> stock;
    private List<CustomerOrder> orders;

    public Warehouse(int locX, int locY, int numProductTypes)
    {
        this.location = new Location(locX, locY);
        this.stock = new ArrayList<List<Product>>();
        this.orders = new ArrayList<CustomerOrder>();

        for(int i = 0; i < numProductTypes; i++)
        {
            this.stock.add(new ArrayList<Product>());
        }
    }

    public Location getLocation()
    {
        return this.location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public void addProduct(Product product)
    {
        //Add product to stock list
        stock.get(product.getProductType()).add(product);
    }

    public void addProducts(List<Product> products)
    {
        Iterator<Product> it = products.iterator();

        while(it.hasNext())
        {
            Product product = it.next();

            this.addProduct(product);
        }
    }

    public void addOrder(CustomerOrder order)
    {
        this.orders.add(order);
    }

    public void addOrders(List<CustomerOrder> orders)
    {
        this.orders.addAll(orders);
    }

    public Product getProduct(int productType)
    {
        Product product;
        Iterator<Product> it = stock.get(productType).iterator();

        if(it.hasNext())
        {
            //Get next product
            product = it.next();

            //Remove product from list
            it.remove();

            //Return product
            return product;
        }
        else
        {
            //List is empty
            return null;
        }
    }

    public CustomerOrder getNextOrder()
    {
        CustomerOrder highPriorOrder;
        CustomerOrder nextOrder;

        Iterator<CustomerOrder> it = this.orders.iterator();

        if(it.hasNext())
        {
            highPriorOrder = it.next();
        }
        else
        {
            //List is empty
            return null;
        }

        while(it.hasNext())
        {
            nextOrder = it.next();

            if(nextOrder.getPriority() > highPriorOrder.getPriority())
            {
                highPriorOrder = nextOrder;
            }
        }

        return highPriorOrder;
    }

    public List<CustomerOrder> getOrders()
    {
        return this.orders;
    }

    public int getNumberOfProductsAvailable(int productType)
    {
        return stock.get(productType).size();
    }
}
