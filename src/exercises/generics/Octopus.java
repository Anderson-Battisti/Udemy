package exercises.generics;

public class Octopus
{
    private String name;
    
    private int tentacles;
    
    public Octopus( String name, int tentacles )
    {
        this.name      = name;
        this.tentacles = tentacles;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
