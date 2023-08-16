public class Testumgebung {
    
    public static void main(String[] a) {
        
        // example:
        MultipleStrings mss = new MultipleStrings( 20 );
        System.out.println( "mss.size() - Ist: " + mss.size() + " (Soll: 0)" );
        mss.addAtPosition( "aabbcc", 0 );
        mss.addAtPosition( "bbaacc", 4 );
        mss.addAtPosition( "abcacc", 2 );
        mss.addAtPosition( "cdefcc", 20 );
        mss.addAtPosition( "ccddee", -5 );
        mss.addAtPosition( "ccddee", 19 );
        mss.addAtPosition( "ghghgc", 10 );
        System.out.println( "mss.size() - Ist: " + mss.size() + " (Soll: 5)" );
        System.out.println( "mss.inAll( 'c' ) - Ist: " + mss.inAll( 'c' ) + " (Soll: true)" );
        System.out.println( "mss.inAll( 'a' ) - Ist: " + mss.inAll( 'a' ) + " (Soll: false)" );
        System.out.println( "mss.inAll( 'x' ) - Ist: " + mss.inAll( 'x' ) + " (Soll: false)" );
        System.out.println( "mss.atEnd( 'cc' ) - Ist: " + mss.atEnd( "cc" ) + " (Soll: 3)" );
        System.out.println( "mss.atEnd( 'c' ) - Ist: " + mss.atEnd( "c" ) + " (Soll: 4)" );
        mss.addAtPosition( "cdefca", 17 );
        System.out.println( "mss.atEnd( 'fca' ) - Ist: " + mss.atEnd( "fca" ) + " (Soll: 1)" );
        mss.replace( 'c', 'a' );
        System.out.println( "mss.inAll( 'a' ) - Ist: " + mss.inAll( 'a' ) + " (Soll: true)" );
        System.out.println( "mss.atEnd( 'c' ) - Ist: " + mss.atEnd( "c" ) + " (Soll: 0)" );
        System.out.println( "mss.atEnd( 'a' ) - Ist: " + mss.atEnd( "a" ) + " (Soll: 5)" );
        

    }

}
