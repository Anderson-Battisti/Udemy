package com.udemyspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Product
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    
    @NotEmpty( message = "Product name must not be empty." )
    private String productName;
    
    public Product() {}
    
    public Product( String productName )
    {
        this.productName = productName;
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setId( long id )
    {
        this.id = id;
    }
    
    public String getName()
    {
        return productName;
    }
    
    public void setProductName( String productName )
    {
        this.productName = productName;
    }
}