package projects.bmi;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.converter.DoubleStringConverter;

public class BMICalculatorPane
    extends 
        VBox
{
    TextField weightField = new TextField();
    TextField heightField = new TextField();
    
    HBox resultRow = new HBox( 10 );
    
    public BMICalculatorPane()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        HBox container = new HBox( 10 );
        
        VBox formContainer = new VBox( 10 );
        formContainer.setPrefWidth( 250 );
        
        VBox imageContainer = new VBox( 10 );
        imageContainer.setPrefWidth( 250 );
        imageContainer.setAlignment( Pos.CENTER );
        
        formContainer.getChildren().addAll( getHeader(), getWeightRow(), getHeightRow(), getButtonRow(), getResultRow() );
        imageContainer.getChildren().addAll( getImage() );
        
        container.getChildren().addAll( formContainer, imageContainer );
        
        getChildren().add( container );
    }
    
    
    
    private Node getHeader()
    {
        Label titleLabel = new Label( "BMI Calculator" );
        titleLabel.setStyle( "-fx-font-size: 16px; -fx-font-weight: bold;" );
        titleLabel.setFont( getDefaultFont() );
        
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
        weightLabel.setFont( getDefaultFont() );
        
        weightField.setStyle( BMIStyles.INPUT_STYLE );
        weightField.setPrefWidth( 60 );
        weightField.setTextFormatter( getDoubleTextFormatter() );
        
        weightField.focusedProperty().addListener( ( observableValue, wasFocused, focused ) -> 
        {
             weightField.setStyle( focused ? BMIStyles.FOCUS_STYLE : BMIStyles.INPUT_STYLE );
        } );
        
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
        heightLabel.setFont( getDefaultFont() );
        
        heightField.setStyle( BMIStyles.INPUT_STYLE );
        heightField.setPrefWidth( 60 );
        heightField.setTextFormatter( getDoubleTextFormatter() );
        
        heightField.focusedProperty().addListener( ( observableValue, wasFocused, focused ) -> 
        {
             heightField.setStyle( focused ? BMIStyles.FOCUS_STYLE : BMIStyles.INPUT_STYLE );
        } );
        
        Label metersLabel = new Label( "m" );
        
        heightRow.getChildren().addAll( heightLabel, heightField, metersLabel );
        
        return heightRow;
    }
    
    private HBox getButtonRow()
    {
        HBox buttonRow = new HBox( 10 );
        buttonRow.setPadding( new Insets( 10 ) );
        
        Button calculateBMIButton = new Button( "Calculate BMI" );
        
        calculateBMIButton.setStyle( BMIStyles.NORMAL_STYLE );
        
        calculateBMIButton.setOnMouseEntered( event -> calculateBMIButton.setStyle( BMIStyles.HOVER_STYLE  ) );
        calculateBMIButton.setOnMouseExited ( event -> calculateBMIButton.setStyle( BMIStyles.NORMAL_STYLE ) );
        
        calculateBMIButton.setOnAction( event -> showBMIResult() );
        
        buttonRow.getChildren().add( calculateBMIButton );
        
        return buttonRow;
    }
    
    private HBox getResultRow()
    {
        resultRow.setVisible( false );
        resultRow.setPadding( new Insets( 10 ) );
        
        return resultRow;
    }
    
    private ImageView getImage()
    {
        ImageView imageView = new ImageView( new Image( "/icons/imc.png" ) );
        imageView.setPreserveRatio( true );
        imageView.setFitWidth ( 180 );
        imageView.setFitHeight( 180 );
        
        return imageView;
    }
    
    private TextFormatter<Double> getDoubleTextFormatter()
    {
        return new TextFormatter<>( new DoubleStringConverter(), 
                                    null,
                                    change ->
                                    {
                                        String newText = change.getControlNewText();
                                        
                                        if ( newText.isEmpty() || newText.matches( "-?\\d*(\\.\\d*)?" ) )
                                        {
                                            return change;
                                        }
                                        
                                        return null;
                                    } );
    }
    
    private Font getDefaultFont()
    {
        return Font.font( "Segoe UI", FontWeight.BOLD, 11 );
    }
    
    private void showBMIResult()
    {
        try
        {
            Label resultLabel = new Label( "Your BMI is: " + String.format( "%.2f", calculateBMI( Double.parseDouble( weightField.getText() ), 
                                                                                                  Double.parseDouble( heightField.getText() ) ) ) );
            
            resultLabel.setFont( getDefaultFont() );
            
            resultRow.getChildren().clear();
            resultRow.getChildren().add( resultLabel );
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
