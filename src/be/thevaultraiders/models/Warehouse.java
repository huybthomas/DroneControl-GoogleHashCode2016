package be.thevaultraiders.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Warehouse
{
    private int locX, locY;
    private List<List<Product>> stock;

    public Warehouse(int locX, int locY, int numProductTypes)
    {
        this.locX = locX;
        this.locY = locY;
        this.stock = new ArrayList<List<Product>>();

        for(int i = 0; i < numProductTypes; i++)
        {
            this.stock.add(new ArrayList<Product>());
        }
    }

    public int getLocX()
    {
        return locX;
    }

    public void setLocX(int locX)
    {
        this.locX = locX;
    }

    public int getLocY()
    {
        return locY;
    }

    public void setLocY(int locY)
    {
        this.locY = locY;
    }

    public void addProduct(Product product)
    {
        //Add product to stock list
        stock.get(product.getProductType()).add(product);
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

    public int getNumberOfProductsAvailable(int productType)
    {
        return stock.get(productType).size();
    }
}
