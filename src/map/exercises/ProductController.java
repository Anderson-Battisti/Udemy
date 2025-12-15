package map.exercises;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.exercises.classes.ProductImplementation;

public class ProductController
{
    private Map<Integer, ProductImplementation> codeToProductMap = new HashMap<>();
    
    // public ProductController() {}
    
    public void insertProduct( Integer code, ProductImplementation product )
    {
        boolean isProeductInserted = codeToProductMap.putIfAbsent( code, product ) == null;
        
        if ( !isProeductInserted )
        {
            System.out.println( "The tried key was already added so the product wasn't added!" );
        }
    }
    
    public Map<Integer, ProductImplementation> getCodeToProductMap()
    {
        return codeToProductMap;
    }
}
