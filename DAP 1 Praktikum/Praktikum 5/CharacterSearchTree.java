public class CharacterSearchTree {

    // Vorgaben

    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public CharacterSearchTree(char[] c) {
        for (int i = 0; i < c.length; i++) {
            iterativeAdd(c[i]);
        }

    }
    public boolean equalStructure( CharacterSearchTree cst){
        if(cst.isEmpty()&&isEmpty()){
            return true;
        }else{
            
        }
        CharacterSearchTree current;
        while(cst.current)

    }

    public boolean containsCharacter(char t) {
        if (!isEmpty()) {
            if (content.getToken() > t) {
                return leftChild.containsCharacter(t);
            } else if (content.getToken() < t) {
                return rightChild.containsCharacter(t);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean hasOnlyCompleteNodes() {
        if (isEmpty() || isLeaf()) {
            return true;
        } else {
            if (!(leftChild.isEmpty() || rightChild.isEmpty())) {
                return leftChild.hasOnlyCompleteNodes() && rightChild.hasOnlyCompleteNodes();
            } else {
                return false;
            }
        }
    }

    public CharacterSearchTree rotateNodeToRight() {
        if (!isEmpty() && !leftChild.isEmpty()) {
            CharacterSearchTree newTree = leftChild;
            leftChild = newTree.rightChild;

            newTree.rightChild = this;
            return newTree;
        } else {
            return this;
        }
    }

    public HuffmanTriple minimum() {
        CharacterSearchTree current = this;
        while (!current.leftChild.isEmpty()) {
            current = current.leftChild;
        }
        return current.content;
    }

    public int longestCode() {
        if (!isEmpty()) {
            return Math.max(Math.max(content.getCode().length(), leftChild.longestCode()),
                    rightChild.longestCode());
        } else {
            return 0;
        }
    }

    public int countCharacters() {
        if (!isEmpty()) {
            return content.getQuantity() + leftChild.countCharacters() + rightChild.countCharacters();
        } else {
            return 0;
        }
    }

    public int height() {
        if (isEmpty()) {
            return 0;
        } else if (isLeaf()) {
            return 1;
        } else {
            int a = leftChild.height();
            int b = rightChild.height();
            return 1 + Math.max(a, b);

        }
    }

    public void add(char t, int q, String c) {

        CharacterSearchTree current = this;
        while (!current.isEmpty() && current.content.getToken() != t) {
            if (current.content.getToken() > t) {
                current = current.leftChild;
            } else if (current.content.getToken() < t) {
                current = current.rightChild;
            }
        }
        if (current.isEmpty()) {
            current.content = new HuffmanTriple(t, q);
            current.content.setCode(c);
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        } else {
            current.content.setCode(c);
            for (int i = 0; i < q; i++) {
                current.content.incrementQuantity();
            }
        }

    }

    public void showPreOrder() {
        if (!isEmpty()) {
            if (isLeaf()) {
                System.out.print(" * ");

            }
            System.out.print(content.toString());
            leftChild.showPreOrder();
            rightChild.showPreOrder();
        }
    }

    public HuffmanTriple getContent() {
        if (!isEmpty()) {
            return content;
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isEmpty() {
        return content == null;
    }

    public boolean isLeaf() {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void iterativeAdd(char t) {
        CharacterSearchTree current = this;
        while (!current.isEmpty() && current.content.getToken() != t) {
            if (current.content.getToken() > t) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        if (current.isEmpty()) {
            current.content = new HuffmanTriple(t);
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        } else {
            current.content.incrementQuantity();
        }
    }

    public void show() {
        if (!isEmpty()) {
            leftChild.show();
            System.out.println(content.toString());
            rightChild.show();
        }
    }

}
