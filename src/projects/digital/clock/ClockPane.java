package projects.digital.clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class ClockPane
    extends
        BorderPane
{
    private Label clockLabel = new Label();
    
    public ClockPane()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        VBox container = new VBox();
        
        container.setAlignment( Pos.CENTER );
        
        updateClock();
        
        container.getChildren().add( getClockLabel() );
        
        setCenter( container );
        
        Timeline timeline = new Timeline( new KeyFrame( Duration.seconds( 1 ), event -> updateClock() ) );
        timeline.setCycleCount( Timeline.INDEFINITE );
        timeline.play();
    }
    
    private Label getClockLabel()
    {
        clockLabel.setFont( Font.font( "Consolas", FontWeight.BOLD, 20 ) );
        
        return clockLabel;
    }
    
    private void updateClock()
    {
        clockLabel.setText( LocalTime.now().format( DateTimeFormatter.ofPattern( "HH:mm:ss" ) ) );
    }
}