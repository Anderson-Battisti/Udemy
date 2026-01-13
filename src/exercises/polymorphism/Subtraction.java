package exercises.polymorphism;

public class Subtraction
    extends
        Operation
{
    @Override
    Double calculate( Double first, Double second )
    {
        return first - second;
    }
}
