package projects.weather.application.project.panes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
        this.setSpacing( 10 );
        this.setFillHeight( false );
        this.setStyle( "-fx-border-color: blue;" );
        
        this.getChildren().addAll( getLeftContainer(), getRightContainer() );
    }
    
    private VBox getLeftContainer()
    {
        VBox leftContainer = new VBox( 10 );
        
        leftContainer.setStyle( "-fx-border-color: green;" );
        leftContainer.prefWidthProperty().bind( this.widthProperty().multiply( 0.4 ) );
        leftContainer.prefHeightProperty().bind( this.heightProperty().multiply( 0.8 ) );
        leftContainer.setFillWidth( true );
        
        Label locationLabel = new Label( weatherData.getCity() + ", " + weatherData.getCountry() );
        locationLabel.setStyle( "-fx-border-color: red; -fx-text-fill: white; -fx-font-size: 22px; -fx-font-weight: bold;" );
        locationLabel.setFont( Font.font( "SN Pro SemiBold", 40 ) );
        locationLabel.setMaxWidth( Double.MAX_VALUE );
        locationLabel.setAlignment(  Pos.CENTER );
        
        leftContainer.getChildren().add( locationLabel );
        
        
        return leftContainer;
    }
    
    private VBox getRightContainer()
    {
        VBox rightContainer = new VBox( 10 );
        rightContainer.setStyle( "-fx-border-color: green;" );
        rightContainer.prefWidthProperty().bind( this.widthProperty().multiply( 0.4 ) );
        rightContainer.prefHeightProperty().bind( this.heightProperty().multiply( 0.8 ) );
        
        return rightContainer;
    }
}