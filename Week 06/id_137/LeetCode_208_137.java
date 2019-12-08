import java.util.HashMap;
import java.util.Map;

public class LeetCode_208_137 {
    static class TrieNode {
        Map<Integer, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public LeetCode_208_137() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int key = ch - 'a';
            if(!curr.children.containsKey(key)) {
                curr.children.put(key, new TrieNode());
            }

            curr = curr.children.get(key);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int key = ch - 'a';
            if(!curr.children.containsKey(key)) {
                return false;
            }
            curr = curr.children.get(key);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            int key = ch - 'a';
            if(!curr.children.containsKey(key)) {
                return false;
            }
            curr = curr.children.get(key);
        }
        return true;
    }
}
