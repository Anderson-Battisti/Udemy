package polymorphism.exercises;

public class Multiplication
    extends
        Operation
{
    @Override
    Double calculate( Double first, Double second )
    {
        return  first * second;
    }
}
