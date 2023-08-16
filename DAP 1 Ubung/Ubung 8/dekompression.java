public class dekompression {
    public static void main(String[] args) {
        String s = "halkonwefen";
        BinaryTree t = new BinaryTree();
        for (int i = 0; i < s.length(); i++) {
            t.add(s.charAt(i));

        }
        System.out.println("binary tree");
        t.show();
        boolean a = t.completePath();
        System.out.println(a);

    }

}
