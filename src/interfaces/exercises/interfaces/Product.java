package interfaces.exercises.interfaces;

public interface Product
{
    void addQuantity( int quantity );
    void removeQuantity( int quantity );
    void printStockMessage();

    String getName();

    int getQuantity();
}
