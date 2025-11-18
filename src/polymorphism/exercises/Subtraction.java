package polymorphism.exercises;

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
