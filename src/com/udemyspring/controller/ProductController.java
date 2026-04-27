package com.udemyspring.controller;

import java.util.List;
import java.util.Optional;

import com.udemyspring.model.Product;
import com.udemyspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping( "/products" )
public class ProductController
{
    @Autowired
    private ProductService productService;
    
    
    /*- Find methods -*/
    
    @GetMapping
    public List<Product> findAll()
    {
        return productService.findAll();
    }
    
    @GetMapping( "/{id}" )
    public Optional<Product> findById( @PathVariable Long id )
    {
        return productService.findById( id );
    }
    
    @GetMapping( "/findByProductName" )
    public List<Product> findByProductName( @RequestParam String productName )
    {
        return productService.findByProductName( productName );
    }
    
    @GetMapping( "/findByProductNameContaining" )
    public List<Product> findByProductNameContaining( @RequestParam String productName )
    {
        return productService.findByProductNameContaining( productName );
    }
    
    @GetMapping( "/findByProductNameAndProductAvailable" )
    public List<Product> findByProductNameAndProductAvailable( @RequestParam String productName, @RequestParam boolean productAvailable )
    {
        return productService.findByProductNameAndProductAvailable( productName, productAvailable );
    }
    
    @GetMapping( "/findByProductNameStartingWith" )
    public List<Product> findByProductNameStartingWith( @RequestParam String prefix )
    {
        return productService.findByProductNameStartingWith( prefix );
    }
    
    @GetMapping( "/findByProductNameEndingWith" )
    public List<Product> findByProductNameEndingWith( @RequestParam String suffix )
    {
        return productService.findByProductNameEndingWith( suffix );
    }
    
    @GetMapping( "/findByPrice" )
    public List<Product> findByPrice( @RequestParam double price )
    {
        return productService.findByPrice( price );
    }
    
    @GetMapping( "/findByPriceGreaterThan" )
    public List<Product> findByPriceGreaterThan( @RequestParam double price )
    {
        return productService.findByPriceGreaterThan( price );
    }
    
    @GetMapping( "/findByPriceLessThan" )
    public List<Product> findByPriceLessThan( @RequestParam double price )
    {
        return productService.findByPriceLessThan( price );
    }
    
    @GetMapping( "/getPricesSum" )
    public Double getPricesSum()
    {
        return  productService.getPricesSum();
    }
    
    @GetMapping( "/getProductCount" )
    public Long getProductCount()
    {
        return productService.count();
    }
    
    
    /*- Save methods -*/
    
    @PostMapping
    public Product save( @RequestBody Product product )
    {
        return productService.save( product );
    }
    
    @PostMapping( "/saveList" )
    public List<Product> saveAll( @RequestBody List<Product> products )
    {
        return productService.saveAll( products );
    }
    
    
    /*- Update methods -*/
    
    @PutMapping( "/{id}" )
    public Product update( @PathVariable Long id, @RequestBody Product product )
    {
        return productService.update( id, product );
    }
    
    
    /*- Delete methods -*/
    
    @DeleteMapping( "/{id}" )
    public void deleteById( @PathVariable Long id )
    {
        productService.delete( id );
    }
}
