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
    
    /*- Find methods -*/
    
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }
    
    public Optional<Product> findById( long id )
    {
        return productRepository.findById( id );
    }
    
    public List<Product> findByProductName( String productName )
    {
        return productRepository.findByProductName( productName );
    }
    
    public List<Product> findByProductNameContaining( String productName )
    {
        return productRepository.findByProductNameContaining( productName );
    }
    
    public List<Product> findByProductNameAndProductAvailable( String productName, boolean productAvailable )
    {
        return productRepository.findByProductNameAndProductAvailable( productName, productAvailable );
    }
    
    public List<Product> findByProductNameStartingWith( String prefix )
    {
        return productRepository.findByProductNameStartingWith( prefix );
    }
    
    public List<Product> findByProductNameEndingWith( String suffix )
    {
        return productRepository.findByProductNameEndingWith( suffix );
    }
    
    public List<Product> findByPrice( double price )
    {
        return productRepository.findByPrice( price );
    }
    
    public List<Product> findByPriceGreaterThan( double price )
    {
        return productRepository.findByPriceGreaterThan( price );
    }
    
    public List<Product> findByPriceLessThan( double price )
    {
        return productRepository.findByPriceLessThan( price );
    }
    
    public Double getPricesSum()
    {
        return productRepository.getPricesSum();
    }
    
    public Long count()
    {
        return productRepository.count();
    }
    
    
    /*- Save methods -*/
    
    public Product save( Product product )
    {
        return productRepository.save( product );
    }
    
    public List<Product> saveAll( List<Product> products )
    {
        return productRepository.saveAll( products );
    }
    
    
    /*- Delete methods -*/
    
    public void delete( long id )
    {
        productRepository.deleteById( id );
    }
    
    /*- Update methods -*/
    
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
