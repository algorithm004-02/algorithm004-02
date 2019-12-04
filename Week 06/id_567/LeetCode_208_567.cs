/*
 * @lc app=leetcode.cn id=208 lang=csharp
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (61.93%)
 * Likes:    150
 * Dislikes: 0
 * Total Accepted:    16.9K
 * Total Submissions: 27K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start

public class Trie {

    private TrieNode _root;

    /** Initialize your data structure here. */
    public Trie() {
        _root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void Insert(string word) {
        TrieNode ws = _root;
        for (int i = 0; i < word.Length; i++) {
            char c = word[i];
            if(ws.Children[c - 'a'] == null){
                ws.Children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.Children[c - 'a'];
        }
        ws.IsWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public bool Search(string word) {
        TrieNode ws = _root; 
        for(int i = 0; i < word.Length; i++){
            char c = word[i];
            if(ws.Children[c - 'a'] == null) return false;
            ws = ws.Children[c - 'a'];
        }
        return ws.IsWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith(string prefix) {
        TrieNode ws = _root; 
        for(int i = 0; i < prefix.Length; i++){
            char c = prefix[i];
            if(ws.Children[c - 'a'] == null) return false;
            ws = ws.Children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    public char Val;
    public bool IsWord;
    public TrieNode[] Children = new TrieNode[26];
    public TrieNode(char c) {
        this.Val = c;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */
// @lc code=end

