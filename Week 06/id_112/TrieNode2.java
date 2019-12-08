package datastruct.trieTree;

/**
 * 字典树结点
 */
public class TrieNode2 {

    public String val;

    public TrieNode2[] child = new TrieNode2[26];

    public boolean isLeaf = false;

    TrieNode2() {

    }
}
