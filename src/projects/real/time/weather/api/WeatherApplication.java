package projects.real.time.weather.api;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONObject;

public class WeatherApplication
{
    private static WeatherApplication instance =  new WeatherApplication();
    
    private WeatherApplication() {}
    
    public static WeatherApplication getInstance()
    {
        if ( instance == null )
        {
            instance = new WeatherApplication();
        }
        
        return instance;
    }
    
    public void initialize()
    {
        System.out.println( "Welcome to the weather application!\n" );
        
        String JSONResponse = getWeatherInfo( getUserInput() );
        
        printResult( JSONResponse );
    }
    
    private String getUserInput()
    {
        String cityName = null;
        
        while ( cityName == null )
        {
            try ( Scanner scanner = new Scanner( System.in ) )
            {
                System.out.println( "Please enter the city name you want to see the infos: " );
                
                return scanner.nextLine();
            }
            
            catch ( Exception e )
            {
                System.out.println( "An error has occurred. Please try again.\n" );
                
                return null;
            }
        }
        
        return cityName;
    }
    
    private String getWeatherInfo( String userInput )
    {
        try
        {
            final String STATIC_API_URL = "https://api.weatherapi.com/v1/current.json";
            final String API_KEY = ApplicationConfig.getPropertyValue( "weather.api.key" );
            
            String cityNameFormatted = URLEncoder.encode( userInput, StandardCharsets.UTF_8 );
            
            String url = String.format( STATIC_API_URL + "?key=%s&q=%s&aqi=no", API_KEY, cityNameFormatted );
            
            HttpRequest request = HttpRequest.newBuilder()
                                             .uri( URI.create( url ) )
                                             .build();
            
            HttpClient client = HttpClient.newHttpClient();
            
            return client.send( request, HttpResponse.BodyHandlers.ofString() ).body();
        }
        
        catch ( Exception e )
        {
            System.out.println( "An error has occurred. Please try again. " + e.getMessage() );
        }
        
        return "";
    }
    
    private void printResult( String JSONResponse )
    {
        JSONObject jsonObject = new JSONObject( JSONResponse );
        
        JSONObject location  = jsonObject.getJSONObject( "location"  );
        JSONObject current   = jsonObject.getJSONObject( "current"   );
        JSONObject condition = current   .getJSONObject( "condition" );
        
        String city             = location .getString( "name"      );
        String country          = location .getString( "country"   );
        String date             = location .getString( "localtime" );
        String weatherCondition = condition.getString( "text"      );
        
        String umidity = String.valueOf( current.getInt( "humidity" ) );
        
        String temperature         = String.valueOf( current.getFloat( "temp_c"      ) );
        String termicSensation     = String.valueOf( current.getFloat( "feelslike_c" ) );
        String windSpeed           = String.valueOf( current.getFloat( "wind_kph"    ) );
        String atmosphericPressure = String.valueOf( current.getFloat( "pressure_mb" ) );
        
        System.out.println( "\nMeteorological information for " + city + ", " + country + ":" );
        System.out.println( "--------------------------------------------------"              );
        System.out.println( "Local date/time     : " + date                                   );
        System.out.println( "Temperature         : " + temperature + " °C"                    );
        System.out.println( "Thermal sensation   : " + termicSensation + " °C"                );
        System.out.println( "Weather condition   : " + weatherCondition                       );
        System.out.println( "Humidity            : " + umidity + " %"                         );
        System.out.println( "Wind speed          : " + windSpeed + " km/h"                    );
        System.out.println( "Atmospheric pressure: " + atmosphericPressure + " mb"            );
    }
}