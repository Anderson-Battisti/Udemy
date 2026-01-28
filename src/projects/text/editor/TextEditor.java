package projects.text.editor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;

import java.io.PrintWriter;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;

public class TextEditor 
    extends 
        Application 
{
    @Override
    public void start( Stage stage ) 
    {
        TextArea editableArea = new TextArea();
        Button   saveButton   = new Button( "Save" );
        
        saveButton.setOnAction( event -> saveText( editableArea ) );

        ToolBar toolBar = new ToolBar( saveButton );

        BorderPane borderPane = new BorderPane();
        borderPane.setTop( toolBar );
        borderPane.setCenter( editableArea );

        Scene scene = new Scene( borderPane, 1000, 750 );
        stage.setTitle( "Basic Text Editor" );
        stage.setScene( scene );
        stage.show();
    }

    private void saveText( TextArea textArea ) 
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle( "Save Text File");
        
        File file = fileChooser.showSaveDialog( null );
        
        if ( file != null ) 
        {
            try ( PrintWriter writer = new PrintWriter( file ) )
            {
                writer.println( textArea.getText() );
            } 
            
            catch ( Exception e ) 
            {
                System.out.println( e.getMessage() );
            }
        }
    }

    static void main( String[] args ) 
    {
        launch( args ); 
    }
}