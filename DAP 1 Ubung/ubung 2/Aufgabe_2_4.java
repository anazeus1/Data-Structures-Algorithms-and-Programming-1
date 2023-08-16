public class Aufgabe_2_4
{
    public static void primeFactorization(int x)
    {
        System.out.print("Primfaktorzerlegung von " + x + " = ");
        
        if (x < 0)
        { //Betrachte ausschließlich positive Zahlen
            x = -x;
        }
        if (x <= 1)
        { //0 und 1 als Sonderfälle gesondert behandeln
           System.out.print(x);
        }
        
        //Bestimme mit Methoden aus der Vorlesung alle Primzahlen bis einschließlich x
        boolean[] numbers = initializeNumbers( x );
        inspectNumbers( numbers );
        int[] primes = primeNumbersToArray( numbers );

        int primeIndex = 0;

        while ( x > 1 )
        {
            if ( x % primes[primeIndex] == 0)
            { 
                System.out.print( primes[primeIndex] );
                x /= primes[primeIndex];

                if (x > 1){ //Wenn x==1 ist der letzte Primfaktor gefunden, sonst gibt es noch min. einen
                    System.out.print(" * ");
                }
            } 
            else 
            {
                primeIndex++;
            }
        }
        System.out.println();
    }

    //Methoden aus der Vorlesung
    public static boolean[] initializeNumbers( int n ) 
    {
        boolean[] numbers = new boolean[n+1];
        for ( int i = 2; i < numbers.length; i++ )
        {
            numbers[i] = true;
        }
        return numbers;
    }

    public static void inspectNumbers( boolean[] numbers ) 
    {
        double limit = Math.sqrt( numbers.length );
        for ( int i = 2; i <= limit; i++ )
        {
            if ( numbers[i] ) 
            {
                discardMultiples( numbers, i );
            }
        }
    }

    public static void discardMultiples( boolean[] numbers, int i ) 
    {
        for ( int j = i*i; j < numbers.length; j+=i ) 
        {
            numbers[j] = false;
        }
    }

    public static int countPrimeNumbers( boolean[] numbers )
    {
        int count = 0;
        for ( boolean b : numbers )
        {
            if ( b ) {
                count++;
            }
        }
        return count;
    }

    public static int[] primeNumbersToArray( boolean[] numbers ) 
    {
        int[] primes = new int[countPrimeNumbers( numbers )];
        int nextPosition = 0;
        for (int i = 0; i < numbers.length; i++) 
        {
            if ( numbers[i] )
            {
                primes[nextPosition] = i;
                nextPosition++;
            }
        }
        return primes;
    }
    
    public static void main(String [] args){
        primeFactorization(204);
        primeFactorization(150);
        primeFactorization(273);
        primeFactorization(293);
    }

}