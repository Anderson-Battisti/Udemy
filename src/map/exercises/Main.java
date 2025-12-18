package map.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import interfaces.exercises.classes.ProductImplementation;

public class Main
{
    static void main( String[] args )
    {
        final Scanner scanner = new Scanner( System.in );
        
        ProductController     productController = new ProductController();
        
        productController.insertProduct( 1, new ProductImplementation( "Mechanical Keyboard - Redragon", 50 ) );
        productController.insertProduct( 2, new ProductImplementation( "Radeon RX 7600 - AMD",           20 ) );
        productController.insertProduct( 3, new ProductImplementation( "Ryzen 5 - 5600GT - AMD",         35 ) );
        productController.insertProduct( 4, new ProductImplementation( "Xbox Series X - Microsoft",      50 ) );
        
        int userChoice = -1;
        
        Map<Integer, ProductImplementation> codeToProductMap = productController.getCodeToProductMap();
        
        System.out.println( "Registered Products: " );
            
        printCodeToProductMap( codeToProductMap );
        
        while ( userChoice != 0 )
        {
            System.out.println( "\nEnter de product code you want to change or 0 to exit: " );
            
            userChoice = readAndGetUserChoice( scanner );
            
            if (  userChoice == 0 )
            {
                break;
            }
            
            if ( codeToProductMap.containsKey( userChoice ) )
            {
                System.out.println( "Enter the new amount of the product '" + codeToProductMap.get( userChoice ).getName() + "'" );
                
                int amountToUpdate = readAndGetUserChoice( scanner );
                
                codeToProductMap.replace( userChoice, new ProductImplementation( codeToProductMap.get( userChoice ).getName(), amountToUpdate ) );
                
                System.out.println( "Updated Products: " );
                
                printCodeToProductMap(  codeToProductMap );
            }
            
            else
            {
                System.out.println( "Invalid code, please enter a valid one or 0 to exit" );
            }
        }
        
        System.out.println( "\nYou entered " + userChoice + " and the program will be closed." );
    }
    
    private static void printCodeToProductMap( Map<Integer, ProductImplementation> codeToProductMap )
    {
        codeToProductMap.forEach( ( key, value ) -> System.out.println( "Code: " + key + " | Item: " + value.getName() + " | Quantity: " + value.getQuantity() ) );
    }
    
    private static int readAndGetUserChoice( Scanner scanner )
    {
        boolean isNotInteger = true;
        int     userChoice = -1;
        
        while ( isNotInteger )
        {
            try
            {
                userChoice = scanner.nextInt();
                
                scanner.nextLine();
                
                isNotInteger = false;
            }
            
            catch ( Exception exception )
            {
                System.out.println( "\nPlease enter an integer number!" );
                
                scanner.nextLine();
            }
        }
        
        return userChoice;
    }
}