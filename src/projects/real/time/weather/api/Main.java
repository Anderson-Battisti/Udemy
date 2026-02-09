package projects.real.time.weather.api;

public class Main
{
    static void main()
    {
        WeatherApplication weatherApplication = WeatherApplication.getInstance();
        
        weatherApplication.initialize();
    }
}
