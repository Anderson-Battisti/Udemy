package fx.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class JavaFXApplication
    extends
        Application
{
    @Override
    public void start( Stage stage )
    {
        stage.setTitle( "JavaFX Test" );
        stage.setScene(new Scene( new Label( "JavaFX is working" ), 300, 120 ) );
        stage.show();
    }
    
    static void main( String[] args )
    {
        launch( args );
    }
}