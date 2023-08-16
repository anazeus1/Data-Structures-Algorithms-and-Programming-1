public class Aufgabe_2_1
{
    public static int greatestProperDivisor( int n )
    {
        if ( n < 0 )
        {
            n = -n;
        }
        
        for ( int i=2; i < n/2; i++ ) 
        {
            if ( n%i == 0 )
            {
                return n/i;
            }
        }
        return 1;
    }
}
