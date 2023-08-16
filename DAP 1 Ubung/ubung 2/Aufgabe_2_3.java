public class Aufgabe_2_3
{
    //unsortierte Felder:
    public static boolean writtenBoth( int[] exam1, int[] exam2 )
    {
        for ( int i=0; i < exam1.length; i++ )
        {
            for ( int k=0; k < exam2.length; k++ )
            {
                if ( exam1[i] == exam2[k] )
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean notWrittenBoth( int [] exam1, int[] exam2 )
    {
        return ! writtenBoth(exam1, exam2);
    }

    public static int countWrittenBoth( int [] exam1, int[] exam2 )
    {
        int count = 0; 
        for ( int i=0; i < exam1.length; i++ )
        {
            for ( int k=0; k < exam2.length; k++)
            {
                if ( exam1[i] == exam2[k] )
                {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean allNrBigger( int[] exam1, int[] exam2 )
    {
        if ( exam1.length > 0 )
        {
            // Minimum von exam1 bestimmen
            int minimum1 = exam1[0];
            for ( int i=1; i < exam1.length; i++ )
            {
                if ( minimum1 > exam1[i] )
                { 
                    minimum1 = exam1[i];
                }
            }
            
            // Minimum vergleichen mit exam2
            for ( int k=0; k < exam2.length; k++ )
            {
                if ( minimum1 <= exam2[k] )
                {
                    return false;
                }
            }
            
            return true;
        }
        return false;
    }

    //aufsteigend sortierte Felder:
    public static boolean writtenBoth_sorted( int [] exam1, int[] exam2 )
    {
        int index1 = 0, index2 = 0;
        while( index1 < exam1.length && index2<exam2.length )
        {
            if ( exam1[index1] == exam2[index2] )
            {
                return true;
            } else {
                if (exam1[index1] < exam2[index2] )
                {
                    index1++;
                } else {
                    index2++;
                }
            }
        }
        return false;
    }

    public static boolean notWrittenBoth_sorted( int [] exam1, int[] exam2 )
    {
        return !writtenBoth_sorted(exam1, exam2);
    }

    public static int countWrittenBoth_sorted( int [] exam1, int[] exam2 )
    {
        int count = 0; 
        int index1 = 0, index2 = 0;
        while( index1 < exam1.length &  index2 < exam2.length )
        {
            if ( exam1[index1] == exam2[index2] )
            {
                count++;
                index1++;
                index2++;
            } else {
                if ( exam1[index1] < exam2[index2] )
                {
                    index1++;
            
                } else {
                    index2++;
                }
            }
        }
        return count;
    }

    public static boolean allNrBigger_sorted( int [] exam1, int[] exam2 )
    {
        if ( exam1.length > 0 & exam2.length > 0 )
        {
            return exam1[0] > exam2[exam2.length - 1];
            //kleinste Nummer in exam1 ist größer als größte in exam2
        }
        return false;
    }

    public static void main( String [] args )
    {
        int size = 500;
        int[] exam1 = new int [size];
        int [] exam2 = new int [size];

        for (int i = 0; i<size ;i++)
        {
            exam1[i] = i+500;
            exam2[i] = i;
        }

        System.out.println( "Unsortiert:"); 
        System.out.println( "writtenBoth: " + writtenBoth(exam1,exam2) ); 
        System.out.println( "notWrittenBoth: " + notWrittenBoth(exam1,exam2) ); 
        System.out.println( "countWrittenBoth: " + countWrittenBoth(exam1,exam2)); 
        System.out.println( "allNrBigger: " + allNrBigger(exam1,exam2) ); 
        
        System.out.println( "Aufsteigend Sortiert:"); 
        System.out.println( "writtenBoth: " + writtenBoth_sorted(exam1,exam2) ); 
        System.out.println( "notWrittenBoth: " + notWrittenBoth_sorted(exam1,exam2) ); 
        System.out.println( "countWrittenBoth: " + countWrittenBoth_sorted(exam1,exam2)); 
        System.out.println( "allNrBigger: " + allNrBigger_sorted(exam1,exam2) ); 
    }
}
