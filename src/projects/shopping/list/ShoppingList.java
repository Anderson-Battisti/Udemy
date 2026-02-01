package projects.shopping.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ShoppingList 
    extends 
        Application
{
    private ArrayList<String> shoppingList = new ArrayList<>();
    private ListView<String>  viewableList = new ListView<>();

    @Override
    public void start( Stage stage ) 
    {
        stage.setTitle( "Shopping List App" );

        TextField itemDescriptionTextField = new TextField();
        
        Button addButton    = new Button( "Add"         );
        Button exportButton = new Button( "Export List" );

        Label addLabel          = new Label( "Enter the item you want to add:" );
        Label shoppingListLabel = new Label( "Shopping List:"                  );

        ObservableList<String> observableShoppingList = FXCollections.observableArrayList( shoppingList );
        
        viewableList.setItems( observableShoppingList );

        VBox vBox = new VBox();
        vBox.getChildren().addAll( addLabel, itemDescriptionTextField, addButton );
        vBox.getChildren().addAll( shoppingListLabel, viewableList, exportButton );
        vBox.setSpacing( 10 );
        vBox.setPadding( new Insets( 10 ) );

        addButton.setOnAction( event -> 
        {
            String item = itemDescriptionTextField.getText();
            
            if ( !item.isEmpty() ) 
            {
                shoppingList.add( item );
                
                viewableList.getItems().add( item );
                
                itemDescriptionTextField.clear();
            }
        } );

        exportButton.setOnAction( event -> 
        {
            try 
            {
                File file = new File( "shoppingList.txt" );
                
                PrintWriter writer = new PrintWriter( file );
                
                for ( String item : shoppingList ) 
                {
                    writer.println( item );
                }
                
                writer.close();
            } 
            
            catch ( Exception exception ) 
            {
                System.out.println( "Error: " + exception.getMessage());
            }
        });

        Scene scene = new Scene( vBox, 350, 300 );
        
        stage.setScene( scene );
        stage.show();
    }

    static void main( String[] args ) 
    {
        launch( args );
    }
}
