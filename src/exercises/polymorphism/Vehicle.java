package exercises.polymorphism;

public abstract class Vehicle
{
    private String plate;
    private int year;

    public Vehicle( String plate, int year )
    {
        this.plate = plate;
        this.year  = year;
    }

    public void showInformations()
    {
        System.out.println( "Plate: " + plate );
        System.out.println( "Year: "  + year  );
    }
}
