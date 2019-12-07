package datastruct.trieTree;

/**
 * Created by 10697 on 2019/11/20.
 */
public class WordTrie {

    public TrieNode2 root = new TrieNode2();

    public void insert(String s) {
        TrieNode2 cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c-'a'] == null) {
                cur.child[c-'a'] = new TrieNode2();
                cur = cur.child[c-'a'];
            } else
                cur = cur.child[c-'a'];
        }
        cur.isLeaf = true;
        cur.val = s;
    }

}
