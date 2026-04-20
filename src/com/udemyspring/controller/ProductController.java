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
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping( "/products" )
public class ProductController
{
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.findAll();
    }
    
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
    
    @PutMapping( "/{id}" )
    public Product update( @PathVariable Long id, @RequestBody Product product )
    {
        return productService.update( id, product );
    }
    
    @DeleteMapping( "/{id}" )
    public void deleteById( @PathVariable Long id )
    {
        productService.delete( id );
    }
    
    @GetMapping( "/{id}" )
    public Optional<Product> findById( @PathVariable Long id )
    {
        return productService.findById( id );
    }
}
