package polymorphism.exercises;

public class Division
    extends
        Operation
{
    @Override
    Double calculate(Double first, Double second)
    {
        return first / second;
    }
}
