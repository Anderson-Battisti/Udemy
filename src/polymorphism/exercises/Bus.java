package polymorphism.exercises;

public class Bus
    extends
        Vehicle
{
    int seats;

    public Bus( String plate, int year, int seats )
    {
        super( plate, year );

        this.seats = seats;
    }

    @Override
    public void showInformations()
    {
        super.showInformations();

        System.out.println( "Seats: " + seats );
    }
}
