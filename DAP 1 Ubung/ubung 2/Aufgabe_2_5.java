public class Aufgabe_2_5
{
    public static boolean isSquare( int[][] matrix )
    {
        for ( int i = 0; i < matrix.length; i++ )
        {
            if ( matrix[i].length != matrix.length )
            {
                return false;
            }
        }
        return true;
    }

    public static void scalarMult( int[][] matrix, int k )
    {
        if ( isSquare( matrix ) )
        {
            for ( int i = 0; i < matrix.length; i++)
            {
                for ( int j = 0; j < matrix[i].length; j++ )
                {
                    matrix[i][j] *= k;
                }
            }
        }
    }

    public static int[] extractDiagonal( int[][] matrix )
    {
        if ( isSquare( matrix ) )
        {
            int[] result = new int[matrix.length];
            for ( int i = 0; i < matrix.length; i++ )
            {
                result[i] = matrix[i][i];
            }
            return result;
        }
        return new int[0];
    }
    
    // for testing
    public static void show ( int[][] matrix )
    {
        for ( int i = 0; i < matrix.length; i++)
        {
            for ( int j = 0; j < matrix[i].length; j++ )
            {
               System.out.print( matrix[i][j] + "\t " );
            }
            System.out.println();
        }
        System.out.println();
    }
}

