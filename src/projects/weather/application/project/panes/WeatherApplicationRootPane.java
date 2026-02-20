package projects.weather.application.project.panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import projects.weather.application.project.model.WeatherData;
import projects.weather.application.project.service.WeatherApplicationService;

public class WeatherApplicationRootPane
    extends
        StackPane
{
    private WeatherApplicationService weatherApplicationService = new WeatherApplicationService();
    
    private BorderPane content = new BorderPane();
    
    public WeatherApplicationRootPane()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        initBackground();
        initOverlay();
        initContent();
    }
    
    private void initBackground()
    {
        Image image = new Image( getClass().getResource( "/weather.application/weather_background_image.jpg" ).toExternalForm() );
        
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
        
        overlay.setStyle( "-fx-background-color: rgba( 0, 0, 0, 0.40 );" );
        
        getChildren().add( overlay );
    }
    
    private void initContent()
    {
        content.setPadding( new Insets( 40 ) );
        content.setStyle("-fx-border-color: yellow;");
        
        content.setTop( createHeader() );
        content.setCenter( emptyStatePane );
        
        getChildren().add( content );
    }
    
    private Node createHeader()
    {
        StackPane headerRoot = new StackPane();
        headerRoot.setPadding( new Insets( 20 ) );
        headerRoot.setStyle("-fx-border-color: red;");
        
        HBox appTitleContainer = new HBox();
        appTitleContainer.setAlignment( Pos.CENTER_LEFT );
        
        StackPane.setAlignment( appTitleContainer, Pos.CENTER_LEFT );
        
        Label appTitle = new Label( "Weather Application" );
        appTitle.setStyle( " -fx-text-fill: white; -fx-font-size: 22px; -fx-font-weight: bold;" );
     
        appTitleContainer.getChildren().add( appTitle );
        
        headerRoot.getChildren().addAll( appTitleContainer, getSearchFieldComponent( headerRoot ) );
        
        return headerRoot;
    }
    
    private Node getSearchFieldComponent( StackPane headerRoot )
    {
        TextField searchField = new TextField();
        
        StackPane searchFieldContainer = new StackPane();
        searchFieldContainer.setMaxWidth( Double.MAX_VALUE );
        searchFieldContainer.maxWidthProperty().bind( headerRoot.widthProperty().multiply( 0.4 ) );
        searchFieldContainer.setStyle( "-fx-border-color: blue;" );
        
        ImageView icon = new ImageView( new Image( getClass().getResourceAsStream( "/weather.application/search_icon.png" ) ) );
        icon.setFitWidth( 25 );
        icon.setFitHeight( 25 );
        icon.setPreserveRatio( true );
        icon.setPickOnBounds( true );
        icon.setCursor( Cursor.HAND );
        icon.setOnMouseClicked( event -> handleSearch( searchField.getText().trim() ) );
        
        
        searchField.setPromptText( "Search city..." );
        searchField.maxWidthProperty().bind( headerRoot.widthProperty().multiply( 0.4 ) );
        searchField.setOnAction( event -> handleSearch( searchField.getText().trim() ) );
        searchField.setStyle( """
                              -fx-background-color: rgba(255,255,255,0.1); 
                              -fx-text-fill: white; 
                              -fx-prompt-text-fill: rgba(255,255,255,0.6); 
                              -fx-background-radius: 8; 
                              -fx-padding: 10 10 10 40; 
                              -fx-border-color: green; 
                              -fx-background-radius: 20; 
                              -fx-border-radius: 20;
                              """ );
        
        StackPane.setAlignment( searchField, Pos.CENTER );
        StackPane.setAlignment( icon, Pos.CENTER_LEFT );
        StackPane.setMargin( icon, new Insets( 0, 0, 0, 10 ) );
        
        searchFieldContainer.getChildren().addAll( searchField, icon );
        
        return searchFieldContainer;
    }
    
    private void handleSearch( String cityName )
    {
        try
        {
            WeatherData fetchedWeatherData = weatherApplicationService.getWeatherData( cityName );
            
            System.out.println( fetchedWeatherData );
            
            if ( fetchedWeatherData != null )
            {
                content.setCenter( new WeatherResultsPane( fetchedWeatherData ) );
            }
        }
        
        catch ( Exception exception )
        {
            emptyStatePane.setEmptyStatePaneState( EmptyStatePane.EmptyStatePaneState.CITY_NOT_FOUND );
            
            content.setCenter( emptyStatePane );
            
            System.out.println( "An error has occurred. Please try again. Error: " + exception.getMessage() );
        }
    }
    
    private EmptyStatePane emptyStatePane = new EmptyStatePane();
}