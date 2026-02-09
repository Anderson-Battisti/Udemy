package projects.real.time.weather.api;

import java.util.Scanner;

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
        
        // TODO: continue the program flow.
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
        final String API_URL = "https://api.weatherapi.com/v1/current.json";
        final String API_KEY = ApplicationConfig.getPropertyValue( "weather.api.key" );
        
        // TODO: CALL API
        
        return "";
    }
}
