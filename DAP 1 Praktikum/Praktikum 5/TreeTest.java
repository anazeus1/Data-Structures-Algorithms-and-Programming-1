public class TreeTest {
    public static void main(String[] args) {
        testMethods();
    }

    private static void testMethods() {
        char[] chars = { 'n', 'd', 'a', 'f', 'b', 'e', 'k', 'i', 'x', 'o', 's', 'z', 'r' };
        CharacterSearchTree cst = new CharacterSearchTree(chars);
        System.out.println("cst.show() - SOLL-Ergebnis: a b d e f i k n o r s x z");
        cst.add('f', 5, "col");
        cst.show();
        cst.showPreOrder();
        int a = cst.longestCode();
        HuffmanTriple b = cst.minimum();
        CharacterSearchTree c = cst.rotateNodeToRight();
        boolean d = cst.containsCharacter('r');
        c.show();
        System.out.println(b.toString());
        System.out.println("+" + a);
        System.out.println(d);

        // weitere Tests ergaenzen
    }

}
