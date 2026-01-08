package serialization.exercises;

import java.io.Serializable;

public class Contact
    implements
        Serializable
{
    private String name;
    private String telephone;
    
    public Contact( String name, String telephone )
    {
        this.name      = name;
        this.telephone = telephone;
    }
    
    @Override
    public String toString()
    {
        return "Name: " + name + ", Telephone: " + telephone;
    }
}
