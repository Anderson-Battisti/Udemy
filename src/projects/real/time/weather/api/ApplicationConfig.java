package projects.real.time.weather.api;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig
{
    private static final Properties PROPS = new Properties();

    private ApplicationConfig() {}
    
    /* static runs when this class is loaded on JVM, running th code in its body */
    static 
    {
        try ( InputStream inputStream = ApplicationConfig.class.getClassLoader().getResourceAsStream( "application.properties" ) ) 
        {
            if ( inputStream == null ) 
            {
                throw new RuntimeException( "application.properties not found" );
            }
            
            PROPS.load( inputStream );
        }
        
        catch ( Exception exception ) 
        {
            throw new RuntimeException( exception );
        }
    }

    public static String getPropertyValue( String propertyName )
    {
        return PROPS.getProperty( propertyName );
    }
}
