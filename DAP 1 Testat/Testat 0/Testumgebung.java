
public class Testumgebung
{
    public static void main(String[] args)
    {
        int[] input1 = {1,2,3,4,5,6};
        printArray( Testat.apply( input1, 3 ) );
        int[] input2 = {1,2,3,3,4,5};
        printArray( Testat.apply( input2, 3 ) );
        int[] input3 = {1,2,3,-3,4,5};
        printArray( Testat.apply( input3, 3 ) );
        int[] input4 = {1,2,3,1,4,1};
        printArray( Testat.apply( input4, 1 ) );
        int[] input5 = {1,2,3};
        printArray( Testat.apply( input5, 4 ) );
        int[] input6 = {1,1,1};
        printArray( Testat.apply( input6, 1 ) );
        int[] input7 = {};
        printArray( Testat.apply( input7 ,1 ) );
    }
    
    private static void printArray( int[] arr ) 
    {
        for ( int content : arr )
        {
            System.out.print ( content + "  " );
        }
        System.out.println( "- Ende");
    }
}