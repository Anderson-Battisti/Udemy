package projects.real.time.weather.api;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class WeatherApplicationPane
    extends
        StackPane
{
    private BorderPane content = new BorderPane();
    
    public WeatherApplicationPane()
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
    
    private void initContent()
    {
        content.setPadding( new Insets( 40 ) );
        content.setStyle("-fx-border-color: yellow;");
        
        content.setTop( createHeader() );
        
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
        
        headerRoot.getChildren().addAll( appTitleContainer, /*searchFieldContainer*/getSearchFieldComponent( headerRoot ) );
        
        return headerRoot;
    }
    
    private Node getSearchFieldComponent( StackPane headerRoot )
    {
        StackPane searchFieldContainer = new StackPane();
        searchFieldContainer.setMaxWidth( Double.MAX_VALUE );
        searchFieldContainer.maxWidthProperty().bind( headerRoot.widthProperty().multiply( 0.2 ) );
        searchFieldContainer.setStyle( "-fx-border-color: blue;" );
        
        ImageView icon = new ImageView( new Image( getClass().getResourceAsStream( "/weather.application/search_icon.png" ) ) );
        icon.setFitWidth( 25 );
        icon.setFitHeight( 25 );
        icon.setPreserveRatio( true );
        
        TextField searchField = new TextField();
        searchField.setPromptText( "Search city..." );
        searchField.maxWidthProperty().bind( headerRoot.widthProperty().multiply( 0.2 ) );
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
}
