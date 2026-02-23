package projects.weather.application.project.panes;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
        
        VBox locationAndDateContainer = new VBox( 10 );
        locationAndDateContainer.setMaxWidth( Double.MAX_VALUE );
        locationAndDateContainer.setAlignment( Pos.CENTER );
        locationAndDateContainer.setStyle( "-fx-border-color: green;" );
        
        
        Label locationLabel = new Label( weatherData.getCity() + ", " + weatherData.getCountry() );
        locationLabel.setStyle( "-fx-border-color: red; -fx-text-fill: white;" );
        locationLabel.setFont( Font.font( "SN Pro SemiBold", 40 ) );
        locationLabel.setMaxWidth( Double.MAX_VALUE );
        locationLabel.setAlignment( Pos.TOP_LEFT );
        
        LocalDate now = LocalDate.now();
        
        Label dateLabel = new Label( now.getDayOfWeek().getDisplayName( TextStyle.SHORT, Locale.ENGLISH ) + ", " 
                                   + now.getMonth().getDisplayName( TextStyle.SHORT, Locale.ENGLISH ) + " " + now.getDayOfMonth() + ", " + now.getYear() + " - "
                                   + weatherData.getDate().split( " " )[ 1 ] );
        
        HBox temperatureContainer = new HBox( 10 );
        temperatureContainer.setAlignment( Pos.CENTER_LEFT );
        temperatureContainer.setMaxWidth( Double.MAX_VALUE );
        temperatureContainer.setMinHeight( 100 );
        temperatureContainer.setStyle( "-fx-border-color: blue;" );
        
        Label temperatureLabel = new Label( weatherData.getTemperature().split( "\\." )[0] + "°C" );
        temperatureLabel.setStyle( "-fx-border-color: green; -fx-text-fill: white;" );
        temperatureLabel.setFont( Font.font( "SN Pro SemiBold", 40 ) );
        HBox.setHgrow( temperatureLabel, Priority.ALWAYS );
        
        VBox iconContainer = new VBox();
        iconContainer.setStyle( "-fx-border-color: blue;" );
        iconContainer.setAlignment( Pos.CENTER_RIGHT );
        
        temperatureContainer.getChildren().addAll( temperatureLabel, iconContainer );
        
        dateLabel.setStyle( "-fx-border-color: yellow; -fx-text-fill: white;" );
        dateLabel.setFont( Font.font( "SN Pro Regular", 20 ) );
        dateLabel.setMaxWidth( Double.MAX_VALUE );
        dateLabel.setAlignment( Pos.TOP_LEFT );
        
        locationAndDateContainer.getChildren().addAll( locationLabel, dateLabel );
        
        leftContainer.getChildren().addAll( locationAndDateContainer, temperatureContainer );
        
        
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