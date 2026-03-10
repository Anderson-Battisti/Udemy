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
    private String precipitationInMilimeters;
    private String uvIndex;
    private String cloudCover;
    private String dewPoint;
    private String windGust;
    private String windDirection;
    private boolean isDay;
    private int weatherConditionCode;
    
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
                        String precipitationInMilimeters,
                        String uvIndex,
                        String cloudCover,
                        String dewPoint,
                        String windGust,
                        String windDirection,
                        boolean isDay,
                        int weatherConditionCode )
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
        this.precipitationInMilimeters = precipitationInMilimeters;
        this.uvIndex = uvIndex;
        this.cloudCover = cloudCover;
        this.dewPoint = dewPoint;
        this.windGust = windGust;
        this.windDirection = windDirection;
        this.isDay = isDay;
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
    
    public String getPrecipitationInMilimeters()
    {
        return precipitationInMilimeters;
    }
    
    public String getUvIndex()
    {
        return uvIndex;
    }
    
    public String getCloudCover()
    {
        return cloudCover;
    }
    
    public String getDewPoint()
    {
        return dewPoint;
    }
    
    public String getWindGust()
    {
        return windGust;
    }
    
    public String getWindDirection()
    {
        return windDirection;
    }
    
    public boolean isDay()
    {
        return isDay;
    }
    
    public int getWeatherConditionCode()
    {
        return weatherConditionCode;
    }
}