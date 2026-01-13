package exercises.polymorphism;

public class Truck
    extends
        Vehicle
{
    int axes;

    public Truck( String plate, int year, int axes )
    {
        super( plate, year );

        this.axes = axes;
    }

    @Override
    public void showInformations()
    {
        super.showInformations();

        System.out.println( "Seats: " + axes );
    }
}
