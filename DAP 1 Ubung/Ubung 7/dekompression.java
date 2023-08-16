public class dekompression {
    public static void main(String[] args) {
        String s = "halloowefen";
        BinaryTree t = new BinaryTree();
        for (int i = 0; i < s.length(); i++) {
            t.add(s.charAt(i));

        }
        System.out.println("binary tree");
        t.show();
        int a = t.size();
        t.breadthFirstTraversal();
        HuffmanCoding hc = new HuffmanCoding(t.toArray());
        String codeOfS = "";
        for (int i = 0; i < s.length(); i++) {
            codeOfS += t.getCode(s.charAt(i));
        }
        System.out.println(codeOfS);
        t.show();

    }

}
