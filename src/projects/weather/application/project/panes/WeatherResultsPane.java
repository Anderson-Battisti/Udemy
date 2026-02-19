package projects.weather.application.project.panes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import projects.weather.application.project.model.WeatherData;

public class WeatherResultsPane
    extends
        HBox
{
    WeatherData weatherData;
    
    public WeatherResultsPane( WeatherData weatherData )
    {
        this.weatherData = weatherData;
        
        initComponents();
    }
    
    private void initComponents()
    {
        this.setAlignment( Pos.CENTER );
        this.setStyle( """
                       -fx-background-color: rgba( 255,255,255,0.2 );
                       -fx-background-radius: 20;
                       -fx-border-radius: 20;
                       -fx-border-color: rgba( 255,255,255,0.1 );
                       """ );
        
        this.getChildren().add( new Label( "TESTE!" ) );
    }
}