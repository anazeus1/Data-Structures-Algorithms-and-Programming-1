public class BreadthFirstTest
{
    public static void main( String[] args )
    {
        testMethods();
    }
    
    private static void testMethods()
    {
        CharacterSearchTree cst = new CharacterSearchTree();
        cst.add('n'); cst.add('d'); cst.add('a'); cst.add('f'); cst.add('b'); cst.add('e'); cst.add('k'); 
        cst.add('i'); cst.add('x'); cst.add('o'); cst.add('s'); cst.add('z'); cst.add('r');        
        System.out.println("cst.show() - SOLL-Ergebnis: a b d e f i k n o r s x z");
        cst.show();
        System.out.println("\ncst.height() - SOLL-Ergebnis: 5");
        System.out.println( cst.height() );
        System.out.println("\ncst.breadthFirstTraversal() - SOLL-Ergebnis: n d x a f o z b e k s i r ");
        cst.breadthFirstTraversal();
        System.out.println();
        System.out.println("\ncst.breadthFirstToArray() - SOLL-Ergebnis: n d x a f o z b e k s i r  ");
        CharacterSearchTree[] bf = cst.breadthFirstToArray();
        for ( CharacterSearchTree c : bf )
        {
            System.out.print( c.getContent().getToken( ) + " " );
        }
      
    }

}

