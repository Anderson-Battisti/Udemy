package exercises.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesController
{
    public static void writeFile( String path, String content )
    {
        Path pathToWrite = Paths.get( path );
        
        try
        {
            Files.write( pathToWrite, content.getBytes() );
        }
        
        catch ( Exception exception )
        {
            System.out.println( "Error writing to file: " + exception.getMessage() );
        }
    }
    
    public static String readFile( String filePath )
    {
        Path pathToRead = Paths.get( filePath );
        
        try
        {
            return new String( Files.readAllBytes( pathToRead ) );
        }
        
        catch ( IOException exception )
        {
            return "Error reading file: " + exception.getMessage();
        }
    }
}
