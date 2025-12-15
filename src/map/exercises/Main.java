package map.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import interfaces.exercises.classes.ProductImplementation;

public class Main
{
    static void main( String[] args )
    {
        ProductController productController = new ProductController();
        
        productController.insertProduct( 1, new ProductImplementation( "Mechanical Keyboard - Redragon", 50 ) );
        productController.insertProduct( 1, new ProductImplementation( "Radeon RX 7600 - AMD",           20 ) );
        productController.insertProduct( 1, new ProductImplementation( "Ryzen 5 - 5600GT - AMD",         35 ) );
        productController.insertProduct( 1, new ProductImplementation( "Xbox Series X - Microsoft",      50 ) );
        
        int userChoice = -1;
        
        Map<Integer, ProductImplementation> codeToProductMap = productController.getCodeToProductMap();
        
        while ( userChoice == 0 )
        {
            System.out.println( "Registered Products: " );
            
            codeToProductMap.forEach( ( key, value ) -> System.out.println( "Code: " + key + " | Item: " + value.getName() + " | Quantity: " + value.getQuantity() ) );
            
            System.out.println( "\nEnter de product code you want to change or 0 to exit: " ); 
            
            readUserChoice( userChoice );
        }
    }
    
    private static void readUserChoice( int userChoice )
    {
        boolean isNotInteger = true;
        
        Scanner scanner = new Scanner( System.in );
        
        while ( isNotInteger )
        {
            try
            {
                userChoice = scanner.nextInt();
                
                isNotInteger = false;
            }
            
            catch ( Exception exception )
            {
                System.out.println( "Please enter an integer number!" );
            }
        }
    }
}