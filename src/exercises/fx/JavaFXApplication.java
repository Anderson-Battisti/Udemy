package exercises.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXApplication
    extends
        Application
{
    @Override
    public void start( Stage stage )
    {
        Label label = new Label( "Hello World! I'm a Label!" );
        label.setStyle( "-fx-background-color: blue; -fx-text-fill: pink; -fx-font-family: 'Arial'; -fx-font-size: 14px; -fx-font-style: italic; -fx-font-weight: bold;" );
        
        Button button = new Button( "Click here!" );
        button.setStyle( "-fx-background-color: rgba( 255, 0, 0, 0.5 ); -fx-text-fill: white;  -fx-font-family: 'Verdana'; -fx-font-size: 12px;" );

        TextField textField = new TextField();
        textField.setStyle( "-fx-background-color: green; -fx-text-fill: red; -fx-font-family: 'Courier New'; -fx-font-size: 16px;" );

        VBox layout = new VBox( label, button, textField );

        Scene scene = new Scene( layout, 300, 200 );

        stage.setScene( scene );
        stage.show();
    }
    
    static void main( String[] args )
    {
        launch( args );
    }
}