public class MultiCountTest
{
    public static void main( String[] args )
    {
        test();
    }

    public static void test()
    {
        FlexibleTree<Student> students = new FlexibleTree<>(new MultiCountStrategy());
        students.add( new Student( "B", "Inf", 18 ) );
        students.add( new Student( "C", "M", 14 ) );
        students.add( new Student( "A", "Inf", 22 ) );
        students.add( new Student( "E", "M", 7 ) );
        students.add( new Student( "E", "M", 7 ) );
        students.add( new Student( "X", "Ph", 7 ) );
        System.out.println( "Testbaum mit 4 Knoten und 6 eingfügten Studierenden: " );
        students.show();
        System.out.println();

        System.out.println( "getQuantity(..7..): " + students.getQuantity( new Student( "E", "M", 7 ) ) );
        System.out.println();

        System.out.println( "size: " + students.size() );
        System.out.println();

        students.add( new Student( "F", "Inf", 17 ) );
        students.add( new Student( "G", "M", 20 ) );
        System.out.println( "Testbaum um 2 Knoten und 2 eingfügte Studierende erweitert: " );
        students.show();
        System.out.println();

        System.out.println( "size: " + students.size() );
        System.out.println();

        System.out.println( "contains(..18..): " + students.contains( new Student( "B", "Inf", 18 ) ) );
        System.out.println();

        System.out.println( "contains(..7..): " + students.contains( new Student( "X", "Ph", 7 ) ) );
        System.out.println();

        System.out.println( "getQuantity(..7..): " + students.getQuantity( new Student( "X", "Ph", 7 ) ) );
        System.out.println();

        System.out.println( "contains(..51..): " + students.contains( new Student( "G", "M", 51 ) ) );
        System.out.println();

        System.out.println( "contains(..17..): " + students.contains( new Student( "F", "Inf", 17 ) ) );
        System.out.println();
        
        System.out.println("\nTests mit delete");
        students.delete(new Student( "17", "Inf", 17 )); System.out.println("delete(..17..)");
        System.out.println( "contains(..17..): " + students.contains( new Student( "F", "Inf", 17 ) ) );
        students.show();
        System.out.println();

       
        System.out.println( "size: " + students.size() );
        System.out.println( "getQuantity(..7..): " + students.getQuantity( new Student( "E", "Inf", 7 ) ) );
        students.delete(new Student( "E", "Inf", 7 )); System.out.println("delete(..7..)");
        System.out.println( "getQuantity(..7..): " + students.getQuantity( new Student( "E", "Inf", 7 ) ) );
        System.out.println( "size: " + students.size() );
        students.delete(new Student( "E", "Inf", 7 )); System.out.println("delete(..7..)");
        System.out.println( "getQuantity(..7..): " + students.getQuantity( new Student( "E", "Inf", 7 ) ) );
        System.out.println( "size: " + students.size() );
        students.show();
        System.out.println();

        students.delete(new Student( "E", "Inf", 7 )); System.out.println("delete(..7..)");
        System.out.println( "getQuantity(..7..): " + students.getQuantity( new Student( "E", "Inf", 7 ) ) );
        System.out.println( "size: " + students.size() );
        students.show();
        System.out.println();

        students.delete(new Student( "B", "Inf", 18 )); System.out.println("delete(..18..)");
        System.out.println( "getQuantity(..18..): " + students.getQuantity( new Student( "B", "Inf", 18 ) ) );
        System.out.println( "size: " + students.size() );
        students.show();
        System.out.println();

    }
}
