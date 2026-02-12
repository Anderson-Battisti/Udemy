package projects.real.time.weather.api;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class WeatherApplicationPane
    extends
        StackPane
{
    public WeatherApplicationPane()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        initBackground();
        initOverlay();
    }
    
    private void initBackground()
    {
        Image image = new Image( getClass().getResource( "/weather.application/weather_background_image.jpeg" ).toExternalForm() );
        
        BackgroundImage backgroundImage = new BackgroundImage( image, 
                                                               BackgroundRepeat.NO_REPEAT, 
                                                               BackgroundRepeat.NO_REPEAT, 
                                                               BackgroundPosition.CENTER, 
                                                               new BackgroundSize( 100, 100, true, true, false, true ) );
        
        setBackground( new Background(  backgroundImage ) );
    }
    
    private void initOverlay()
    {
        Pane overlay = new Pane();
        
        overlay.setStyle(  "-fx-background-color: rgba( 0, 0, 0, 0.60 );" );
        
        getChildren().add( overlay );
    }
}
