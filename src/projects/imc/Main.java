package projects.imc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main
    extends
        Application
{
    static void main( String[] args )
    {
        launch( args );
    }
    
    @Override
    public void start( Stage stage )
    {
        Scene scene = new Scene( new IMCCalculatorPane(), 500, 400 );
        
        stage.setTitle( "IMC Calculator" );
        stage.setScene( scene );
        stage.show();
    }
}
