package exercises.securerandom;

import java.security.SecureRandom;

public class RandomPasswordGenerator
{
    public static String generateRandomPassword( int passwordSize )
    {
        final String CARACTERES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%&()*+-/:;<=>?@[]_{|}";
        
        SecureRandom secureRandom = new SecureRandom();
        
        StringBuilder randomPassword = new StringBuilder( passwordSize );
        
        for( int i = 0; i < passwordSize; i++ )
        {
            randomPassword.append( CARACTERES.charAt( secureRandom.nextInt( CARACTERES.length() ) ) ) ;
        }
        
        return randomPassword.toString();
    }
}