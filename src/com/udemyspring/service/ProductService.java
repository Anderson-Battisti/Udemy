package com.udemyspring.service;

import java.util.List;
import java.util.Optional;

import com.udemyspring.model.Product;
import com.udemyspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }
    
    public Optional<Product> findById( long id )
    {
        return productRepository.findById( id );
    }
    
    public Product save( Product product )
    {
        return productRepository.save( product );
    }
    
    public void delete( long id )
    {
        productRepository.deleteById( id );
    }
    
    public Product update( Long id, Product product )
    {
        if ( productRepository.existsById( id ) )
        {
            product.setId( id );
            
            return productRepository.save( product );
        }
        
        else
        {
            throw new RuntimeException( "Product not found." );
        }
    }
}
