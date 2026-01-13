package exercises.polymorphism;

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
