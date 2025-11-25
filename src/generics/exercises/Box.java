package generics.exercises;

public class Box<T>
{
    private int capacity;
    private T[] box;
    
    public Box( int capacity )
    {
        box = (T[]) new Object[ capacity ];
    }
    
    public void add( T element, int index )
    {
        box[ index ] = element;
    }
    
    public T get( int index )
    {
        return box[ index ];
    }
}