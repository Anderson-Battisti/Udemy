package polymorphism.exercises;

public class Sum
    extends
        Operation
{
    @Override
    Double calculate( Double first, Double second )
    {
        return first + second;
    }
}
