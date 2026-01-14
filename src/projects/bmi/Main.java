package projects.bmi;

import java.util.Objects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        Scene scene = new Scene( new BMICalculatorPane(), 500, 400 );
        
        stage.getIcons().add( new Image( Objects.requireNonNull( getClass().getResourceAsStream( "/icons/imc.png" ) ) ) );
        stage.setTitle( "BMI Calculator" );
        stage.setScene( scene );
        stage.show();
    }
}
