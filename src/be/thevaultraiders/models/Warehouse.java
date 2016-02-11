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
    private List<List<Product>> reservedStock;
    private List<CustomerOrder> readyOrders;
    private List<CustomerOrder> waitingOrders;

    public Warehouse(int locX, int locY, int numProductTypes)
    {
        this.location = new Location(locX, locY);
        this.stock = new ArrayList<List<Product>>();
        this.reservedStock = new ArrayList<List<Product>>();
        this.readyOrders = new ArrayList<CustomerOrder>();
        this.waitingOrders = new ArrayList<CustomerOrder>();

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

    public void addStockProduct(Product product)
    {
        //Add product to stock list
        this.stock.get(product.getProductType()).add(product);
    }

    public void addStockProducts(List<Product> products)
    {
        Iterator<Product> it = products.iterator();

        while(it.hasNext())
        {
            Product product = it.next();

            this.addStockProduct(product);
        }
    }

    public void addReservedProduct(Product product)
    {
        //Add product to reserved list
        this.reservedStock.get(product.getProductType()).add(product);
    }

    public void addReservedProducts(List<Product> products)
    {
        Iterator<Product> it = products.iterator();

        while(it.hasNext())
        {
            Product product = it.next();

            this.addReservedProduct(product);
        }
    }

    public Product getStockProduct(int productType)
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

    private CustomerOrder getNextOrder(List<CustomerOrder> orders)
    {
        CustomerOrder highPriorOrder;
        CustomerOrder nextOrder;

        Iterator<CustomerOrder> it = orders.iterator();

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

    /**
     * Pop the next ready order from stack
     * @return The next priority order
     */
    public CustomerOrder popNextReadyOrder()
    {
        return this.getNextOrder(this.readyOrders);
    }

    /**
     * Pop the next waiting order from stack
     * @return The next priority order
     */
    public CustomerOrder popNextWaitingOrder()
    {
        return this.getNextOrder(this.waitingOrders);
    }

    public List<CustomerOrder> getWaitingOrders()
    {
        return this.waitingOrders;
    }

    public List<CustomerOrder> getReadyOrders()
    {
        return this.readyOrders;
    }

    public int getNumberOfProductsAvailable(int productType)
    {
        return stock.get(productType).size();
    }

    public void placeOrder(CustomerOrder order)
    {
        int i;
        List<Integer> productsRequired = new ArrayList<Integer>();

        for(i = 0; i < order.getReqProducts().size(); i++)
        {
            int productType = order.getReqProducts().get(i).getProductType();
            productsRequired.set(productType, productsRequired.get(productType) + 1);
        }

        //Check if all products are available
        i = 0;
        boolean underStock = false;

        while(i < productsRequired.size() && !underStock)
        {
            if(this.stock.get(i).size() < productsRequired.get(i))
            {
                underStock = true;
            }

            i++;
        }

        if(underStock)
        {
            //Order can not be placed
            this.waitingOrders.add(order);
        }
        else
        {
            //Order can be placed
            for(i = 0; i < productsRequired.size(); i++)
            {
                this.addReservedProduct(this.getStockProduct(order.getReqProducts().get(i).getProductType()));
            }

            this.readyOrders.add(order);
        }
    }
}
