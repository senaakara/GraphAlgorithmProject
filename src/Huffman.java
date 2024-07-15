import java.util.Comparator;
class Huffman {
    public static void sifreYazdir(HuffmanNode root, String s)
    {
        if (root.left
                == null
                && root.getRight()
                == null
                && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        if (root.left == null) throw new AssertionError();
        sifreYazdir(root.left, s + "0");
        sifreYazdir(root.getRight(), s + "1");
    }
}
class HuffmanNode {
    int data;
    char c;
    HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode getRight() {
        return right;
    }
    public void setRight(HuffmanNode right) {
        this.right = right;
    }
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode a, HuffmanNode b)
    {
        return a.data - b.data;
    }
}

