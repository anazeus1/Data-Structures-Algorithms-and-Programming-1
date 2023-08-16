


public class TestAllClasses
{
    
    public static void main() 
    {
        Period d1 = new Period(270);
        Period d2 = d1.clone();
        d2.change(66);
        System.out.println("d1 = " + d1.toString());
        System.out.println("d2 = " + d2.toString());
        System.out.println();
        PointInTime z1 = new PointInTime(2012,365,22);
        PointInTime z2 = z1.clone();
        z2.change(17);
        System.out.println("z1 = " + z1.toString());
        System.out.println("z2 = " + z2.toString());
        System.out.println();
        Date date1 = new Date("date1", z1, d1);
        Date date2 = date1.clone();
        date2.change(17);
        System.out.println(date1.toString());
        System.out.println(date2.toString());
        Date date3 = new Date("date3", null, null);
        System.out.println(date3.toString());
        date3.set( new PointInTime(2015,100,20), null );
        System.out.println(date3.toString());
        date3.change(25);
        System.out.println(date3.toString());
    }
    
}
