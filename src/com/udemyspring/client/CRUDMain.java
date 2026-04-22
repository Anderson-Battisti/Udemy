package com.udemyspring.client;

import com.udemyspring.model.Product;

public class CRUDMain
{
    static void main()
    {
        CRUDJavaClient javaClient = new CRUDJavaClient();
        
        Product updatedProduct = new Product( "Monitor", true );
        Product product = new Product( "Tablet", true );
        
        javaClient.save( product );
        javaClient.updateProduct( 52, updatedProduct );
        javaClient.listAllProducts();
        javaClient.deleteProduct( 52 );
        javaClient.listAllProducts();
    }
}
