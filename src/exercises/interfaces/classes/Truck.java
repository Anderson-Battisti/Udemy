package exercises.interfaces.classes;

import exercises.interfaces.interfaces.Vehicle;

public class Truck
    implements
        Vehicle
{
    @Override
    public void start()
    {
        System.out.println( "Truck starting" );
    }

    @Override
    public void stop()
    {
        System.out.println( "Truck stopped" );
    }
}
