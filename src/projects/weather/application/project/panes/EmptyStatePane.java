package projects.weather.application.project.panes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class EmptyStatePane
    extends
        VBox
{
    private EmptyStatePaneState emptyStatePaneState = EmptyStatePaneState.INITIAL;
    
    public EmptyStatePane()
    {
        initComponents();
    }
    
    public enum EmptyStatePaneState
    {
        INITIAL, CITY_NOT_FOUND
    }
    
    public void setEmptyStatePaneState( EmptyStatePaneState emptyStatePaneState )
    {
        this.emptyStatePaneState = emptyStatePaneState;
        
        refreshContent();
    }
    
    private void refreshContent()
    {
        this.getChildren().clear();
        
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
        
        this.parentProperty().addListener( ( obs, oldParent, newParent ) ->
        {
            if ( newParent instanceof Region parentRegion )
            {
                this.maxWidthProperty().bind( parentRegion.widthProperty().multiply( 0.5 ) );
                this.maxHeightProperty().bind( parentRegion.heightProperty().multiply( 0.7 ) );
            }
        } );
        
        this.getChildren().add( getCardContentLayer() );
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
        cardTitle.setText( emptyStatePaneState == EmptyStatePaneState.INITIAL ? "Search for a city to see the weather" : 
                                                                                "No results found for that city." );
        cardTitle.setFont( Font.font( "SN Pro SemiBold", 40 ) );
        cardTitle.setStyle( "-fx-text-fill: white;" );
        
        Label cardDescription = new Label();
        cardDescription.setTextAlignment( TextAlignment.CENTER );
        cardDescription.setText( emptyStatePaneState == EmptyStatePaneState.INITIAL ? "Enter a city name in the search bar to view current weather \nconditions, including temperature and detailed information." :
                                                                                      "We couldn’t find that city. Please check the spelling and try again." );
        cardDescription.setFont( Font.font( "SN Pro SemiBold", 20 ) );
        cardDescription.setStyle( "-fx-text-fill: white;" );
        
        cardTextContainer.getChildren().addAll( cardTitle, cardDescription );
        
        return cardTextContainer;
    }
}