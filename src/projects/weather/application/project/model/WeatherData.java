package projects.weather.application.project.model;

public class WeatherData
{
    private String city;
    private String country;
    private String date;
    private String temperature;
    private String termicSensation;
    private String weatherCondition;
    private String umidity;
    private String windSpeed;
    private String atmosphericPressure;
    
    public WeatherData( String city,
                        String country,
                        String date, 
                        String temperature, 
                        String termicSensation, 
                        String weatherCondition, 
                        String umidity, 
                        String windSpeed, 
                        String atmosphericPressure )
    {
        this.city                = city;
        this.country             = country;
        this.date                = date;
        this.temperature         = temperature;
        this.termicSensation     = termicSensation;
        this.weatherCondition    = weatherCondition;
        this.umidity             = umidity;
        this.windSpeed           = windSpeed;
        this.atmosphericPressure = atmosphericPressure;
    }
    
    /* Getters */
    public String getDate()
    {
        return date;
    }

    public String getTemperature()
    {
        return temperature;
    }

    public String getTermicSensation()
    {
        return termicSensation;
    }

    public String getWeatherCondition()
    {
        return weatherCondition;
    }

    public String getUmidity()
    {
        return umidity;
    }

    public String getWindSpeed()
    {
        return windSpeed;
    }

    public String getAtmosphericPressure()
    {
        return atmosphericPressure;
    }
}
