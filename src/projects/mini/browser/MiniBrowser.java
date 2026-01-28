package projects.mini.browser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MiniBrowser
    extends 
        Application
{
    @Override
    public void start( Stage stage )
    {
        TextField urlField  = new TextField();
        WebView   webView   = new WebView();
        WebEngine webEngine = webView.getEngine();
        
        urlField.setOnAction( event -> webEngine.load( formataUrl( urlField.getText() ) ) );
        
        VBox vbox = new VBox();
        
        vbox.getChildren().addAll( urlField, webView );
        
        Scene scene = new Scene( vbox );
        
        stage.setTitle( "My Java Browser" );
        stage.setScene( scene );
        stage.show();
    }
    
    public String formataUrl( String url )
    {
        if ( !url.startsWith( "http://" ) && !url.startsWith( "https://" ) )
        {
            url = "http://" + url;
        }
        
        return url;
    }
    
    static void main( String[] args )
    {
        launch( args );
    }
}