import java.util.*;
class TrieNode {
    private char c;
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean yaprakMi;

    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isYaprakMi() {
        return yaprakMi;
    }

    public void setYaprakMi(boolean yaprakMi) {
        this.yaprakMi = yaprakMi;
    }
}

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void kelimeEkle(String kelime) {
        HashMap<Character, TrieNode> children = root.getChildren();
        for(int i = 0; i < kelime.length(); i++) {
            char c = kelime.charAt(i);
            TrieNode node;
            if(children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();

            if(i == kelime.length() - 1) {
                node.setYaprakMi(true);
            }
        }
    }

    public boolean bulunduMu(String kelime) {
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode node = null;
        for(int i = 0; i < kelime.length(); i++) {
            char c = kelime.charAt(i);
            if(children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            } else {
                node = null;
                break;
            }
        }

        return node != null && node.isYaprakMi();
    }

}