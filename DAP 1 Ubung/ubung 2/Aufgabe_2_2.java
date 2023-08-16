public class Aufgabe_2_2
{

    public static int countPairs(int [] arr)
    {
        int count=0;
        for (int i = 1; i < arr.length; i++ )
        {
            if ( arr[i-1] == arr[i] )
            {
                count++;
                i++;
            }
        }
        return count;
    }
    
    public static void main(String [] args)
    {
        int[] bsp1 = {1,1,3,3,1,2,2,2,1};
        int[] bsp2 = {1,3,3,3,3,2,2,5,5};

        System.out.println( "Beispiel 1: " + countPairs(bsp1) ); 
        System.out.println( "Beispiel 2: " + countPairs(bsp2) ); 
    }

}
