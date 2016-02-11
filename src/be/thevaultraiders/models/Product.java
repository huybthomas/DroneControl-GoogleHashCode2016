package be.thevaultraiders.models;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Product
{
    private int productType;
    private int payload;

    public Product(int productType, int payload)
    {
        this.productType = productType;
        this.payload = payload;
    }

    public int getProductType()
    {
        return productType;
    }

    public void setProductType(int productType)
    {
        this.productType = productType;
    }

    public int getPayload()
    {
        return payload;
    }

    public void setPayload(int payload)
    {
        this.payload = payload;
    }
}
