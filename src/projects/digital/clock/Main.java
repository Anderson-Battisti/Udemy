package projects.digital.clock;

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
        Scene scene = new Scene( new ClockPane(), 250, 200 );
        
        stage.getIcons().add( new Image( Objects.requireNonNull( getClass().getResourceAsStream( "/icons/digital-clock.png" ) ) ) );
        stage.setTitle( "Digital Clock" );
        stage.setScene( scene );
        stage.show();
    }
}
