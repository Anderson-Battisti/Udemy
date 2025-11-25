package generics.exercises;

import java.util.List;

public class Basket<T>
{
    private T object;
    
    public void save( T object )
    {
        this.object = object;
    }
    
    public T getItem()
    {
        return this.object;
    }
}
