package functional.interfaces.exercises;

public class CustomizedCalculator
{
    public static void showCalcValues()
    {
        MathematicalOperation powCalc  = Math::pow;
        MathematicalOperation sqrtCalc = ( ( number1, number2 ) -> Math.sqrt( number1 + number2 ) );
        
        System.out.println( "Power of: "       + powCalc .execute( 4, 6 ) );
        System.out.println( "Square Root of: " + sqrtCalc.execute( 4, 6 ) );
    }
}
