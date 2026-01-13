package exercises.functional.interfaces;

@FunctionalInterface
public interface MathematicalOperation
{
    abstract double execute( double number1, double number2 );
}