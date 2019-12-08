package datastruct.trieTree;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 字典树结点
 */
public class TrieNode {

   // R links to node children
    private  TrieNode[] links;

    private final int R = 26;

    private  boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch,TrieNode node) {
        links[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}
