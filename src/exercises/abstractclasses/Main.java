package exercises.abstractclasses;

public class Main
{
    public static void main( String[] args )
    {
        Rectangle rectangle = new Rectangle( 5, 3 );

        System.out.println( "Rectangle area: "      + rectangle.calculateArea()      + "m²" );
        System.out.println( "Rectangle perimeter: " + rectangle.calculatePerimeter() + "m"  );

        CommercialStore store = new CommercialStore();
        store.open();
        store.close();
    }
}