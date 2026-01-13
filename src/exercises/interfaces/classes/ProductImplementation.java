package exercises.interfaces.classes;

import exercises.interfaces.interfaces.Product;

public class ProductImplementation
    implements
        Product
{
    String name = "";

    int quantity = 0;

    public ProductImplementation( String name, int quantity )
    {
        this.name     = name;
        this.quantity = quantity;
    }

    @Override
    public void addQuantity( int quantity )
    {
        this.quantity += quantity;
    }

    @Override
    public void removeQuantity( int quantity )
    {
        if ( this.quantity >= quantity )
        {
            this.quantity -= quantity;
        }

        else
        {
            System.out.println( "Not enough quantity to remove. Operation not completed." );
        }
    }

    @Override
    public void printStockMessage()
    {
        System.out.println( "Now the stock has " + this.getQuantity() + " " + this.getName() + "(s)" );
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public int getQuantity()
    {
        return this.quantity;
    }
}
