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
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

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
        content.setCenter( createEmptyStatePane() );
        
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
        StackPane searchFieldContainer = new StackPane();
        searchFieldContainer.setMaxWidth( Double.MAX_VALUE );
        searchFieldContainer.maxWidthProperty().bind( headerRoot.widthProperty().multiply( 0.4 ) );
        searchFieldContainer.setStyle( "-fx-border-color: blue;" );
        
        ImageView icon = new ImageView( new Image( getClass().getResourceAsStream( "/weather.application/search_icon.png" ) ) );
        icon.setFitWidth( 25 );
        icon.setFitHeight( 25 );
        icon.setPreserveRatio( true );
        
        TextField searchField = new TextField();
        searchField.setPromptText( "Search city..." );
        searchField.maxWidthProperty().bind( headerRoot.widthProperty().multiply( 0.4 ) );
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
    
    private Node createEmptyStatePane()
    {
        StackPane emptyStateContainer = new StackPane();
        emptyStateContainer.setAlignment( Pos.CENTER );
        emptyStateContainer.setStyle( "-fx-border-color: red;" );
        
        emptyStateContainer.getChildren().add( getCardLayer() );
        
        return emptyStateContainer;
    }
    
    private VBox getCardLayer()
    {
        VBox card = new VBox();
        card.setAlignment( Pos.CENTER );
        card.setStyle( """
                       -fx-background-color: rgba( 255,255,255,0.2 );
                       -fx-background-radius: 20;
                       -fx-border-radius: 20;
                       -fx-border-color: rgba( 255,255,255,0.1 );
                       """ );
        
        card.parentProperty().addListener( ( obs, oldParent, newParent ) ->
        {
            if ( newParent instanceof Region parentRegion )
            {
                card.maxWidthProperty().bind( parentRegion.widthProperty().multiply( 0.5 ) );
                card.maxHeightProperty().bind( parentRegion.heightProperty().multiply( 0.7 ) );
            }
        } );
        
        card.getChildren().add( getCardContentLayer() );
        
        return card;
    }
    
    private VBox getCardContentLayer()
    {
        VBox cardContent = new VBox();
        cardContent.setSpacing( 100 );
        cardContent.setAlignment( Pos.CENTER );
        
        cardContent.getChildren().addAll( getCloudImage(), getCardTextContainer() );
        
        return cardContent;
    }
    
    private SVGPath getCloudImage()
    {
        SVGPath cloudImage = new SVGPath();
        cloudImage.setContent( "M12 9.5V12.5M12 15.5H12.01M8.4 19C5.41766 19 3 16.6044 3 13.6493C3 11.2001 4.8 8.9375 7.5 8.5C8.34694 6.48637 10.3514 5 12.6893 5C15.684 5 18.1317 7.32251 18.3 10.25C19.8893 10.9449 21 12.6503 21 14.4969C21 16.9839 18.9853 19 16.5 19L8.4 19Z" );
        cloudImage.setFill( null );
        cloudImage.setStroke( Color.WHITE );
        cloudImage.setStrokeWidth( 1 );
        cloudImage.setScaleX( 9 );
        cloudImage.setScaleY( 9 );

        cloudImage.setStrokeLineCap( StrokeLineCap.ROUND );
        cloudImage.setStrokeLineJoin( StrokeLineJoin.ROUND );
        
        return cloudImage;
    }
    
    private VBox getCardTextContainer()
    {
        VBox cardTextContainer = new VBox();
        cardTextContainer.setAlignment( Pos.CENTER );
        cardTextContainer.setSpacing( 15 );
        
        Label cardTitle = new Label();
        cardTitle.setAlignment( Pos.CENTER );
        cardTitle.setText( "Search for a city to see the weather" );
        cardTitle.setFont( Font.font( "SN Pro SemiBold", 40 ) );
        cardTitle.setStyle( "-fx-text-fill: white;" );
        
        Label cardDescription = new Label();
        cardDescription.setTextAlignment( TextAlignment.CENTER );
        cardDescription.setText( "Enter a city name in the search bar to view current weather \nconditions, including temperature and detailed information." );
        cardDescription.setFont( Font.font( "SN Pro SemiBold", 20 ) );
        cardDescription.setStyle( "-fx-text-fill: white;" );
        
        cardTextContainer.getChildren().addAll( cardTitle, cardDescription );
        
        return cardTextContainer;
    }
}