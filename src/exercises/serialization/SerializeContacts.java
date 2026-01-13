package exercises.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializeContacts
{
    public static void serializeContacts( List<Contact> contacts ) throws IOException
    {
        try( ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream( "resources\\agenda.ser" ) ) )
        {
            outputStream.writeObject( contacts );
            
            System.out.println( "Contacts serialized successfully!" );
        }
    }
    
    public static void deserializeContacts() throws IOException, ClassNotFoundException
    {
        try ( ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream( "resources\\agenda.ser" ) ) )
        {
            if ( inputStream.readObject() instanceof List<?> contactList )
            {
                contactList.forEach( System.out::println );
            }
        }
    }
}
