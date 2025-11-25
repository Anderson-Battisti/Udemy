package generics.exercises;

public class Fish
{
    private String name;
    private Double size;
    
    public Fish( String name, Double size )
    {
        this.name = name;
        this.size = size;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
}