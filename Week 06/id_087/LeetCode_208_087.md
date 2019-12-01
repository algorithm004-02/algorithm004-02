# 208. 实现 Trie (https://leetcode-cn.com/problems/implement-trie-prefix-tree/)

## 题目

实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

==示例==

```
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
```

==说明:==

* 你可以假设所有的输入都是由小写字母 a-z 构成的。
* 保证所有输入均为非空字符串。

## 实现

```
class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchWith(word);
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchWith(prefix);
        return node != null;
    }

    private TrieNode searchWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return null;
            }
            node = node.get(ch);
        }
        return node;
    }
}
```


