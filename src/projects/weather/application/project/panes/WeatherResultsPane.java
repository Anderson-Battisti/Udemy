package projects.weather.application.project.panes;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
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
        this.setSpacing( 20 );
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
        
        Label locationLabel = new Label( weatherData.getCity() + ", " + weatherData.getRegion() + ", " + weatherData.getCountry() );
        locationLabel.setStyle( "-fx-border-color: red; -fx-text-fill: white;" );
        locationLabel.setFont( Font.font( "SN Pro SemiBold", 40 ) );
        locationLabel.setMaxWidth( Double.MAX_VALUE );
        locationLabel.setAlignment( Pos.TOP_LEFT );
        locationLabel.setWrapText( true );
        
        LocalDate now = LocalDate.now();
        
        Label dateLabel = new Label( now.getDayOfWeek().getDisplayName( TextStyle.SHORT, Locale.ENGLISH ) + ", " 
                                   + now.getMonth().getDisplayName( TextStyle.SHORT, Locale.ENGLISH ) + " " + now.getDayOfMonth() + ", " + now.getYear() + " - "
                                   + weatherData.getDate().split( " " )[ 1 ] );
        
        dateLabel.setStyle( "-fx-border-color: yellow; -fx-text-fill: white;" );
        dateLabel.setFont( Font.font( "SN Pro Regular", 20 ) );
        dateLabel.setMaxWidth( Double.MAX_VALUE );
        dateLabel.setAlignment( Pos.TOP_LEFT );
        
        locationAndDateContainer.getChildren().addAll( locationLabel, dateLabel );
        
        //TEMPERATURE CONTAINER
        HBox temperatureContainer = new HBox( 10 );
        temperatureContainer.setAlignment( Pos.CENTER_LEFT );
        temperatureContainer.setMaxWidth( Double.MAX_VALUE );
        temperatureContainer.setMinHeight( 200 );
        temperatureContainer.setStyle( "-fx-border-color: blue;" );
        
        Label temperatureLabel = new Label( weatherData.getTemperature().split( "\\." )[0] + "°C" );
        temperatureLabel.setStyle( "-fx-border-color: green; -fx-text-fill: white;" );
        temperatureLabel.setFont( Font.font( "SN Pro SemiBold", 60 ) );
        HBox.setHgrow( temperatureLabel, Priority.ALWAYS );
        
        VBox iconContainer = new VBox();
        iconContainer.setStyle( "-fx-border-color: blue;" );
        iconContainer.setAlignment( Pos.CENTER );
        iconContainer.setPadding( new Insets( 0, 0, 0, 20 ) );
        
        Label weatherStatusLabel = new Label( weatherData.getWeatherCondition() );
        weatherStatusLabel.setStyle( "-fx-text-fill: white;" );
        weatherStatusLabel.setFont( Font.font( "SN Pro SemiBold", 20 ) );
        
        iconContainer.getChildren().addAll( getResultIcon( weatherData.getWeatherConditionCode() ), weatherStatusLabel );
        
        temperatureContainer.getChildren().addAll( temperatureLabel, iconContainer );
        
        // LEFT CONTAINER
        leftContainer.getChildren().addAll( locationAndDateContainer, temperatureContainer, getInfoLineComponent() );
        
        return leftContainer;
    }
    
    private ImageView getResultIcon( int weatherConditionCode )
    {
        String iconPath = switch ( weatherConditionCode ) 
        {
            case 1000                                                             -> "/icons/sun.png";
            case 1003                                                             -> "/icons/partly-cloudy.png";
            case 1006, 1009                                                       -> "/icons/clouds.png";
            case 1030, 1135, 1147                                                 -> "/icons/fog.png";
            case 1063, 1150, 1153, 1168, 1171                                     -> "/icons/drizzle.png";
            case 1087, 1273, 1276, 1279, 1282                                     -> "/icons/thunderstorm.png";
            case 1180, 1183, 1186, 1189, 1192, 1195, 1240, 1243, 1246             -> "/icons/heavy-rain.png";
            case 1066, 1114, 1117, 1210, 1213, 1216, 1219, 1222, 1225, 1255, 1258 -> "/icons/snowy.png";
            case 1069, 1072, 1198, 1201, 1204, 1207, 1237, 1249, 1252, 1261, 1264 -> "/icons/snowy.png";
    
            default -> "/icons/clouds.png";
        };
        
        Image resultIcon = new Image( getClass().getResource( iconPath ).toExternalForm() );
        ImageView resultIconView = new ImageView( resultIcon );
        resultIconView.setFitWidth ( 100 );
        resultIconView.setFitHeight( 100 );
        
        return resultIconView;
    }
    
    private VBox getInfoLineComponent()
    {
        VBox componentContainer = new VBox();
        componentContainer.setSpacing( 20 );

        componentContainer.getChildren().addAll( getInfoLineComponent( "Feels Like", weatherData.getTermicSensation()        + " Cº"   ),
                                                 getInfoLineComponent( "Humidity",   weatherData.getHumidity()               + " %"    ),
                                                 getInfoLineComponent( "Wind",       weatherData.getWindSpeed()              + " km/h" ),
                                                 getInfoLineComponent( "Visibility", weatherData.getKilometersOfVisibility() + " km"   ) );
        
        return  componentContainer;
    }
    
    private VBox getInfoLineComponent( String firstLabel, String resultLabel )
    {
        VBox infoLineContainer = new VBox();
        
        HBox infoContainer = new HBox( 10 );
        
        Label feelsLikeLabel = new Label( firstLabel );
        feelsLikeLabel.setStyle( "-fx-text-fill: white;" );
        feelsLikeLabel.setFont( Font.font( "SN Pro SemiBold", 18 ) );
        
        Region spacer = new Region();
        HBox.setHgrow( spacer, Priority.ALWAYS );
        
        Label feelsLikeTemerature = new Label( resultLabel );
        feelsLikeTemerature.setStyle( "-fx-text-fill: white;" );
        feelsLikeTemerature.setFont( Font.font( "SN Pro SemiBold", 18 ) );
        
        infoContainer.getChildren().addAll( feelsLikeLabel, spacer, feelsLikeTemerature );
        
        Region line = new Region();
        line.setPrefHeight( 0.5 );
        line.setMaxWidth( Double.MAX_VALUE );
        line.setStyle( "-fx-background-color: white;" );
        
        infoLineContainer.getChildren().addAll( infoContainer, line );
        
        return infoLineContainer;
    }
    
    private VBox getRightContainer()
    {
        VBox rightContainer = new VBox( 10 );
        rightContainer.setStyle( "-fx-border-color: green;" );
        rightContainer.prefWidthProperty().bind( this.widthProperty().multiply( 0.4 ) );
        rightContainer.prefHeightProperty().bind( this.heightProperty().multiply( 0.8 ) );
        
        return rightContainer;
    }
    
    private HBox getSecondaryInfosCard( String label, String resultLabel, String iconPath )
    {
        HBox secondaryInfosCard = new HBox( 10 );
        
        VBox iconDiv = new VBox();
        
        Image icon = new Image( getClass().getResource( iconPath ).toExternalForm() );
        ImageView iconView = new ImageView( icon );
        
        iconDiv.getChildren().add( iconView );
        
        VBox infoDiv = new VBox( 10 );
        
        Label infoLabel = new Label( label );
        
        Label infoResult = new Label( resultLabel );
        
        infoDiv.getChildren().addAll( infoLabel, infoResult );
        
        secondaryInfosCard.getChildren().addAll( iconDiv, infoDiv );
        
        return secondaryInfosCard;
    }
}