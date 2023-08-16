/*represent a tree consisting of HuffmanTriple nodesnodes */

import java.nio.channels.IllegalSelectorException;

public class HuffmanTree {
    /* Contents of a node tree structure */
    private HuffmanTriple content;
    private HuffmanTree leftChild;
    private HuffmanTree rightChild;

    /* constructor show an empty tree */
    public HuffmanTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    /* shows a knot with conten */
    public HuffmanTree(HuffmanTriple content) {
        this.content = content;
        leftChild = new HuffmanTree();
        rightChild = new HuffmanTree();

    }

    /* shows the root */
    public HuffmanTree(HuffmanTree leftChild, HuffmanTree rightChild) {
        content = new HuffmanTriple(' ',
                leftChild.getContent().getFrequency() + rightChild.getContent().getFrequency());
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public HuffmanTriple getContent() {
        if (!isEmpty()) {
            return content;

        } else {
            throw new IllegalStateException();
        }

    }

    /* identify emty tree */
    public boolean isEmpty() {
        return content == null;
    }

    public boolean isLeaf() {
        /* has no childs and not empty */
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public int compareTo(HuffmanTree other) {
        if (!isEmpty() && !other.isEmpty()) {
            return content.compareTO(other.content);
        } else {
            throw new IllegalSelectorException();
        }
    }

    public void generateCodes() {
        /* stoping criteria */
        if (!isEmpty() && !isLeaf())
        /* if its a leaf there is no no children to give codes to */ {
            leftChild.content.setCoding(content.getCoding() + "0");
            rightChild.content.setCoding(content.getCoding() + "1");
            /* rekursive methode generate code for sub trees */
            leftChild.generateCodes();
            rightChild.generateCodes();
        }
    }

    public void showCodes() {
        if (!isEmpty()) {
            if (isLeaf()) {
                System.out.println(content.toString());
            } else {
                leftChild.showCodes();
                rightChild.showCodes();
                ;
            }
        }
    }

    private String decoded = "";

    public String decode(String encoded) {
        if (encoded != "") {

            if (encoded.charAt(0) == '0') {
                if (leftChild.isEmpty()) {
                    return decoded + content.getletter();
                } else {
                    leftChild.decode(encoded.substring(1));
                }

            } else {
                if (rightChild.isEmpty()) {
                    return decoded + content.getletter();
                } else {
                    rightChild.decode(encoded.substring(1));
                }

            }
        }

102.
        return decoded;

    }

}