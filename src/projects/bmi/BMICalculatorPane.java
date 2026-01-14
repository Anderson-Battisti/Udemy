package projects.bmi;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;

public class BMICalculatorPane
    extends 
        VBox
{
    TextField weightField = new TextField();
    TextField heightField = new TextField();
    
    HBox resultRow = new HBox( 10 );
    
    Label resultNumber = new Label();
    
    public BMICalculatorPane()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        getChildren().addAll( getHeader(), getWeightRow(), getHeightRow(), getButtonRow(), getResultRow() );
    }
    
    private Node getHeader()
    {
        Label titleLabel = new Label( "BMI Calculator" );
        titleLabel.setStyle( "-fx-font-size: 16px; -fx-font-weight: bold;" );
        
        StackPane header = new StackPane( titleLabel );
        header.setPadding( new Insets( 20 ) );
        
        return header;
    }
    
    private HBox getWeightRow()
    {
        HBox weightRow = new HBox( 10 );
        weightRow.setPadding( new Insets( 10 ) );
        weightRow.setAlignment( Pos.CENTER );
        weightRow.setAlignment( Pos.CENTER_LEFT );
        
        Label weightLabel = new Label( "Weight: " );
        weightLabel.setStyle( "-fx-pref-width: 45" );
        
        weightField.setPrefWidth( 60 );
        weightField.setTextFormatter( getDoubleTextFormatter() );
        
        Label kgLabel = new Label( "kg" );
        
        weightRow.getChildren().addAll( weightLabel, weightField, kgLabel );
        
        return weightRow;
    }
    
    private HBox getHeightRow()
    {
        HBox heightRow = new HBox( 10 );
        heightRow.setPadding( new Insets( 10 ) );
        heightRow.setAlignment( Pos.CENTER );
        heightRow.setAlignment( Pos.CENTER_LEFT );
        
        Label heightLabel = new Label( "Height: " );
        heightLabel.setStyle( "-fx-pref-width: 45" );
        
        heightField.setPrefWidth( 60 );
        heightField.setTextFormatter( getDoubleTextFormatter() );
        
        Label metersLabel = new Label( "m" );
        
        heightRow.getChildren().addAll( heightLabel, heightField, metersLabel );
        
        return heightRow;
    }
    
    private HBox getButtonRow()
    {
        HBox buttonRow = new HBox( 10 );
        buttonRow.setPadding( new Insets( 10 ) );
        
        Button calculateBMIButton = new Button( "Calculate BMI" );
        calculateBMIButton.setStyle( "-fx-pref-width: 115" );
        
        calculateBMIButton.setOnAction( event -> showBMIResult() );
        
        buttonRow.getChildren().add( calculateBMIButton );
        
        return buttonRow;
    }
    
    private HBox getResultRow()
    {
        resultRow.setVisible( false );
        
        Label resultLabel = new Label( "Result: " + resultNumber.getText() );
        
        resultRow.getChildren().add( resultLabel );
        
        return resultRow;
    }
    
    private TextFormatter<Double> getDoubleTextFormatter()
    {
        TextFormatter<Double> doubleTextFormatter = new TextFormatter<>( new DoubleStringConverter(), 
                                                                         null,
                                                                         change ->
                                                                         {
                                                                             String newText = change.getControlNewText();
                                                                             
                                                                             if ( newText.isEmpty() || newText.matches( "-?\\d*(\\.\\d*)?" ) )
                                                                             {
                                                                                 return change;
                                                                             }
                                                                             
                                                                             return null;
                                                                         });
        
        return doubleTextFormatter;
    }
    
    private void showBMIResult()
    {
        try
        {
            resultNumber.setText( String.format( "%.2f", calculateBMI( Double.parseDouble( weightField.getText() ), 
                                                                       Double.parseDouble( heightField.getText() ) ) ) );
            
            resultRow.setVisible( true );
        }
        
        catch ( Exception exception )
        {
            System.out.println( "Error: " + exception.getMessage() );
        }
    }
    
    public Double calculateBMI( Double weight, Double height )
    {
        return weight / ( height * height );
    }
}
