package com.udemyspring.runner;

import java.util.Arrays;
import java.util.List;

import com.udemyspring.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate;

public class StartupRestClientRunner
    implements
        CommandLineRunner
{
    @Override
    public void run( String... args )
    {
        String url = "http://localhost:8080/products";
        
        Product[] products = new RestTemplate().getForObject( url, Product[].class );
        
        List<Product> productsList = Arrays.stream( products != null ? products : new Product[ 0 ] ).toList();
        
        productsList.forEach( product -> System.out.println( "ID: " + product.getId() + " | Name: " + product.getName() ) );
    }
}