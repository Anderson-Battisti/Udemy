package exercises.interfaces.classes;

import exercises.interfaces.interfaces.Vehicle;

public class Car
    implements
        Vehicle
{
    @Override
    public void start()
    {
        System.out.println( "Car starting" );
    }

    @Override
    public void stop()
    {
        System.out.println( "Car stopped" );
    }
}
