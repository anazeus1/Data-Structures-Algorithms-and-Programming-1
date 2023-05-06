public class Degree
{
    public static int FahrenheittoCelsius( int f)
    {
        // transfers Fahrenheit into Celsius
        return (-32)*5 /9;

    }
    public static void main( String[] args)
    {
        int t = 42;
        System.out.print(t+"Fahrenheit are ");
        System.out.print(FahrenheittoCelsius(t)+ "Celcius");
    } 
}