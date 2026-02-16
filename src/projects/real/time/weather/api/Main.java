package projects.real.time.weather.api;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
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
    public void start( Stage stage ) throws Exception
    {
        Font.loadFont( getClass().getResource( "/fonts/SNPro-SemiBold.ttf" ).toExternalForm(), 10 );
        
        Scene scene = new Scene( new WeatherApplicationPane() );
        
        stage.setMaxHeight( Double.MAX_VALUE );
        stage.setMaxWidth( Double.MAX_VALUE );
        stage.setTitle( "Weather Application" );
        stage.getIcons().add( new Image( getClass().getResourceAsStream( "/weather.application/application_icon.png" ) ) );
        stage.setMaximized( true );
        stage.setScene( scene );
        stage.show();
    }
}
