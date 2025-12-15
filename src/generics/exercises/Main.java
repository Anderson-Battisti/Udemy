package generics.exercises;

import java.util.Map;
import java.util.Set;

public class Main
{
    public static void main( String[] args )
    {
        Basket basket = new Basket();
        
        basket.save( new Octopus( "My Octopus", 8 ) );
        
        System.out.println( basket.getItem() );
        
        basket.save( new Fish( "My Fish", 3.5 ) );
        
        System.out.println( basket.getItem() );
        
        Box<Double> doubleBox = new Box<>( 2 );
        doubleBox.add( 3.43, 0 );
        doubleBox.add( 5.29, 1 );
        
        System.out.println( doubleBox.get( 0 ) );
        System.out.println( doubleBox.get( 1 ) );
        
        Box<Character> charBox = new Box<>( 3 );
        
        charBox.add( 'a', 0 );
        charBox.add( 'b', 1 );
        charBox.add( 'c', 2 );
        
        System.out.println( charBox.get( 0 ) );
        System.out.println( charBox.get( 1 ) );
        System.out.println( charBox.get( 2 ) );
    }
}