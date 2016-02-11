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

    /**
     * Product type identifier
     * @return integer starting from 0
     */
    public int getProductType()
    {
        return productType;
    }

    /**
     * Product type identifier
     * @param productType integer starting from 0
     */
    public void setProductType(int productType)
    {

        this.productType = productType;
    }

    /**
     * Get weight of the product
     * @return integer weight of the product
     */
    public int getPayload()
    {
        return payload;
    }

    /**
     * Set weight of the product
     * @param payload weight of the product
     */
    public void setPayload(int payload)
    {
        this.payload = payload;
    }
}
