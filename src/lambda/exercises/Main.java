package lambda.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main
{
    /* The remotion of 'public' is a Java 25 feature! */
    static void main()
    {
        
        // Exercise 1 //
       
        /* A TreeSet is being used here to obtain an ordered Set */
        Set<Integer> numbers = new TreeSet<>( Set.of( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 ) ); 
        
        numbers.forEach( number -> 
        {
            if ( number % 2 == 0 ) System.out.println( number );
        } );
        
        
        // Exercise 2
        
        List<String> randomWords = new ArrayList<>( List.of( "Apple", "Banana", "Keyboard", "Whatever", "Computer", "House", "Key" ) );
        
        randomWords.removeIf( word -> word.length() > 5 );
        randomWords.addFirst( "Egg" );
        randomWords.forEach( System.out::println );
    }
}
