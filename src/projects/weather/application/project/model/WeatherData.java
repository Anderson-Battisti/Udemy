package projects.weather.application.project.model;

public class WeatherData
{
    private String city;
    private String region;
    private String country;
    private String date;
    private String temperature;
    private String termicSensation;
    private String weatherCondition;
    private String umidity;
    private String windSpeed;
    private String atmosphericPressure;
    private String kilometersOfVisibility;
    private int    weatherConditionCode;
    
    public WeatherData( String city,
                        String region,
                        String country,
                        String date,
                        String temperature,
                        String termicSensation,
                        String weatherCondition,
                        String umidity,
                        String windSpeed,
                        String atmosphericPressure,
                        String kilometersOfVisibility,
                        int    weatherConditionCode )
    {
        this.city = city;
        this.region = region;
        this.country = country;
        this.date = date;
        this.temperature = temperature;
        this.termicSensation = termicSensation;
        this.weatherCondition = weatherCondition;
        this.umidity = umidity;
        this.windSpeed = windSpeed;
        this.atmosphericPressure = atmosphericPressure;
        this.kilometersOfVisibility = kilometersOfVisibility;
        this.weatherConditionCode = weatherConditionCode;
    }
    
    /* Getters */
    public String getCity()
    {   
        return city;
    }
    
    public String getRegion()
    {
        return region;
    }
    
    public String getCountry()
    {
        return country;
    }
    
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
    
    public String getHumidity()
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
    
    public String getKilometersOfVisibility()
    {
        return kilometersOfVisibility;
    }
    
    public int getWeatherConditionCode()
    {
        return weatherConditionCode;
    }
}
