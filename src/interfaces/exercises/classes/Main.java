package interfaces.exercises.classes;

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
    }
}
