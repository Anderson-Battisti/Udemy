package projects.imc;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class IMCCalculatorPane
    extends 
        VBox
{
    public IMCCalculatorPane()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        // VBox container = new VBox( 10 );
        
        getChildren().addAll( getHeader() );
    }
    
    private Node getHeader()
    {
        Label titleLabel = new Label( "IMC Calculator" );
        titleLabel.setStyle( "-fx-font-size: 16px; -fx-font-weight: bold;" );
        
        StackPane header = new StackPane( titleLabel );
        header.setPadding( new Insets( 20 ) );
        
        return header;
    }
}
