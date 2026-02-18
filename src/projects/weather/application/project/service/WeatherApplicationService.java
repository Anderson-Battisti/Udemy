package projects.weather.application.project.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;
import projects.weather.application.project.config.ApplicationConfig;
import projects.weather.application.project.model.WeatherData;

public class WeatherApplicationService
{
    public WeatherData getWeatherData( String cityName ) throws Exception
    {
        if ( cityName == null && cityName.isEmpty() )
        {
            return null;
        }
        
        String JSONResponse = getAPIResponse( cityName );
        
        if ( JSONResponse == null )
        {
            return null;
        }
        
        return getWeatherDataObject( JSONResponse );
    }
    
    private String getAPIResponse( String cityName ) throws Exception
    {
        final String STATIC_API_URL = "https://api.weatherapi.com/v1/current.json";
        final String API_KEY        = ApplicationConfig.getPropertyValue( "weather.api.key" );
        
        String cityNameFormatted = URLEncoder.encode( cityName, StandardCharsets.UTF_8 );
        
        String url = String.format( STATIC_API_URL + "?key=%s&q=%s&aqi=no", API_KEY, cityNameFormatted );
        
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri( URI.create( url ) )
                                         .build();
        
        HttpClient client = HttpClient.newHttpClient();
        
        return client.send( request, HttpResponse.BodyHandlers.ofString() ).body();
    }
    
    private WeatherData getWeatherDataObject( String JSONResponse )
    {
        JSONObject jsonObject = new JSONObject( JSONResponse );
        
        JSONObject location  = jsonObject.getJSONObject( "location"  );
        JSONObject current   = jsonObject.getJSONObject( "current"   );
        JSONObject condition = current   .getJSONObject( "condition" );
        
        String city                = location.getString( "name"      );
        String country             = location.getString( "country"   );
        String date                = location.getString( "localtime" );
        String temperature         = String.valueOf( current.getFloat( "temp_c" ) );
        String termicSensation     = String.valueOf( current.getFloat( "feelslike_c" ) );
        String weatherCondition    = condition.getString( "text" );
        String humidity            = String.valueOf( current.getInt( "humidity" ) );
        String windSpeed           = String.valueOf( current.getFloat( "wind_kph" ) );
        String atmosphericPressure = String.valueOf( current.getFloat( "pressure_mb" ) );
        
        return new WeatherData( city, country, date, temperature, termicSensation, weatherCondition, humidity, windSpeed, atmosphericPressure );
    }
}