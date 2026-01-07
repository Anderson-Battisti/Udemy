package nio.exercises;

public class Main
{
    static void main()
    {
        FilesController.writeFile( "resources\\myFile.txt", "Hello World! This is an example of creating and reading a file using Java NIO!" );
        
        System.out.println( FilesController.readFile( "myFile.txt" ) );
    }
}
