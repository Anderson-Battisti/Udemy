package exercises.interfaces.classes;

public class Main
{
    public static void main( String[] args )
    {
        Car car = new Car();
        car.start();
        car.honk();
        car.stop();

        Truck truck = new Truck();
        truck.start();
        truck.honk();
        truck.stop();

        Order order = new Order();
        order.addItem( "Milk",      4.99 );
        order.addItem( "Chocolate", 1.99 );
        order.addItem( "Potato",    1.99 );
        order.addItem( "Beer",      2.99 );

        order.calculateTotal();

        ProductImplementation blackShirt = new ProductImplementation( "Black Shirt", 50 );
        blackShirt.addQuantity( 40 );
        blackShirt.printStockMessage();
        blackShirt.removeQuantity( 100 );
    }
}