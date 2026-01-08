package serialization.exercises;

import java.io.IOException;
import java.util.List;

public class Main
{
    static void main()
    {
        try
        {
            SerializeContacts.serializeContacts( List.of( new Contact( "Giuseppe", "99 9999-9999" ), 
                                                          new Contact( "Giacomo",  "11 1111-1111" ),
                                                          new Contact( "Matteo",   "88 8888-8888" ) ) );
            
            SerializeContacts.deserializeContacts();
        }
        
        catch ( IOException | ClassNotFoundException exception )
        {
            System.out.println( "Error handling contacts: " + exception.getMessage() );
        }
    }
}
