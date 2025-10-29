package abstractclasses.exercises;

public class Rectangle
    extends
        AbstractGeometricFigure
{
    int width;
    int height;

    public Rectangle( int width, int height )
    {
        this.width  = width;
        this.height = height;
    }

    @Override
    public int calculateArea()
    {
        return width * height;
    }

    @Override
    public int calculatePerimeter()
    {
        return width * 2 + height * 2;
    }
}