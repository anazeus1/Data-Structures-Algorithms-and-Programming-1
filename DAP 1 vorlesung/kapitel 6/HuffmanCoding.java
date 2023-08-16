
public class HuffmanCoding {
    public static void main(String[] args) {
        HuffmanTriple[] tokens1 = {
                new HuffmanTriple('a', 5),
                new HuffmanTriple('b', 6),
                new HuffmanTriple('c', 9),
                new HuffmanTriple('d', 10),
                new HuffmanTriple('e', 15),
                new HuffmanTriple('f', 28),
                new HuffmanTriple('g', 32),
        };
        HuffmanCoding hc = new HuffmanCoding(tokens1);
        hc.showCodeTable();
        String a = hc.trees[hc.trees.length - 1].decode("11010011");
        System.out.println(a);
    }

    /* an array ith roots for the subtrees */
    private HuffmanTree[] trees;

    public HuffmanCoding(HuffmanTriple[] input) {
        // compression only if different tokens appear
        if (input.length > 1) {
            initializeTrees(input);
            buildTree();
            trees[trees.length - 1].generateCodes();
        } else {
            throw new IllegalStateException();
        }
    }

    private void initializeTrees(HuffmanTriple[] input) {
        trees = new HuffmanTree[input.length];
        for (int i = 0; i < input.length; i++) {
            trees[i] = new HuffmanTree(input[i]);
        }
    }

    private void buildTree() {
        /* */
        for (int i = 0; i + 1 < trees.length; i++) {
            insertionSort(i);/* only the relevant trees are sorted */
            /* sum two trees content together and make them children of a new tree */
            trees[i + 1] = new HuffmanTree(trees[i], trees[i + 1]);
        }
    }

    private void insertionSort(int start) {
        for (int i = start + 1; i < trees.length; i++) {
            shiftTrees(i);
        }
    }

    private void shiftTrees(int start) {
        if (start < trees.length) {
            HuffmanTree toInsert = trees[start];
            int i = start;
            while (i > 0 && trees[i - 1].compareTo(toInsert) > 0) {
                trees[i] = trees[i - 1];
                i--;
            }
            trees[i] = toInsert;
        }
    }

    public void showCodeTable() {
        trees[trees.length - 1].showCodes();
    }
}