package functional.interfaces.exercises;

@FunctionalInterface
public interface MathematicalOperation
{
    abstract double execute( double number1, double number2 );
}