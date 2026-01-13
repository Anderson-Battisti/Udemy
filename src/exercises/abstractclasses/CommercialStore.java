package exercises.abstractclasses;

public class CommercialStore
    extends
        AbstractStore
{
    @Override
    public void open()
    {
        System.out.println( "Opening the store..." );
    }

    @Override
    public void close()
    {
        System.out.println( "Closing the store..." );
    }
}