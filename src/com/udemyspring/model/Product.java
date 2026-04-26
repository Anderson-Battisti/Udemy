package com.udemyspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    
    @NotEmpty( message = "Product name must not be empty." )
    private String productName;
    
    @NotNull
    @Column( nullable = false, columnDefinition = "boolean default false" )
    private boolean productAvailable;
    
    @NotNull
    @Column( nullable = false )
    private double price;
    
    public Product() {}
    
    public Product( String productName, boolean productAvailable )
    {
        this.productName      = productName;
        this.productAvailable = productAvailable;
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
    
    public boolean isProductAvailable()
    {
        return productAvailable;
    }
}