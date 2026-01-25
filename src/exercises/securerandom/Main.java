package exercises.securerandom;

import java.util.Scanner;

public class Main
{
    static void main()
    {
        Scanner scanner = new Scanner( System.in );
        
        System.out.println( "Enter the number of characters you want for your random password: " );
                      
        String randomPassword = RandomPasswordGenerator.generateRandomPassword( readNumber( scanner ) );
        
        System.out.println( "Random password generated: " + randomPassword );
    }
    
    private static Integer readNumber( Scanner scanner )
    {
        while ( true )
        {
            try
            {
                int passwordSize;
                
                passwordSize = scanner.nextInt();
                
                return passwordSize;
            }
            
            catch ( Exception e )
            {
                System.out.println( "Invalid input! try again." );
                
                scanner.next();
            }
        }
    }
}