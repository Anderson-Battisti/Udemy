package abstractclasses.exercises;

public abstract class AbstractStore
{
    private String cnpj;
    private String legalName;
    private boolean open;

    public abstract void open();
    public abstract void close();
}