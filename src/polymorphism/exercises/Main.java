package polymorphism.exercises;

public class Main
{
    public static void main( String[] args )
    {
        Bus bus = new Bus( "OPR1", 2013, 30 );
        bus.showInformations();

        Truck truck = new Truck( "OPR2", 2015, 4 );
        truck.showInformations();

        System.out.println( new Sum()           .calculate( 5.3, 2.0  ) );
        System.out.println( new Multiplication().calculate( 5.9, 4.0  ) );
        System.out.println( new Subtraction()   .calculate( 3.6, 1.6  ) );
        System.out.println( new Division()      .calculate( 87.3, 3.8 ) );
    }
}
