package interfaces.exercises.interfaces;

public interface Vehicle
{
    void start();
    void stop();

    default void honk()
    {
        System.out.println( "Honking!" );
    }
}
