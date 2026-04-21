package com.udemyspring.client;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.udemyspring.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CRUDJavaClient
{
    private static final String BASE_URL = "http://localhost:8080/products";
    
    private RestTemplate restTemplate;
    
    public CRUDJavaClient()
    {
        this.restTemplate = new RestTemplate();
    }
    
    public void listAllProducts()
    {
        ResponseEntity<Product[]> response = restTemplate.getForEntity( BASE_URL, Product[].class );
        
        List<Product> products = Arrays.asList( response.getBody() );
        
        products.forEach( product -> System.out.println( "ID: " + product.getId() + " | Name: " + product.getName() ) );
    }
    
    public Product save( Product product )
    {
        HttpEntity<Product> request = new HttpEntity<>( product );
        
        return restTemplate.postForObject( BASE_URL, request, Product.class );
    }
    
    public void deleteProduct( long id )
    {
        restTemplate.delete( BASE_URL + "/" + id );
    }
    
    public Product updateProduct( long id, Product product )
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        
        HttpEntity<Product> request = new HttpEntity<>( product, httpHeaders );
        
        ResponseEntity<Product> response = restTemplate.exchange( BASE_URL + "/" + id, HttpMethod.PUT, request, Product.class );
        
        return response.getBody();
    }
    
    public Product findProductById( long id )
    {
        ResponseEntity<Product> response = restTemplate.getForEntity( BASE_URL + "/" + id, Product.class );
        
        return response.getBody();
    }
}
