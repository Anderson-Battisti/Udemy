package exercises.interfaces.classes;

import exercises.interfaces.interfaces.RestaurantOrders;

import java.util.HashMap;
import java.util.Map;

public class Order
    implements
        RestaurantOrders
{
    private final Map<String, Double> items = new HashMap<>();

    @Override
    public void addItem( String item, double price )
    {
        items.put( item, price );
    }

    @Override
    public void calculateTotal()
    {
        double total = 0;

        for ( Double value : items.values() )
        {
            total += value;
        }

        items.keySet().forEach( key -> System.out.println( "Item: " + items.get( key ) ) );

        System.out.println( "Total Price: " + String.format( "%.2f", total ) );
    }
}