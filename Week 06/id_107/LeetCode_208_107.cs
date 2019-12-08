/*
    208. 实现 Trie (前缀树)
    实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */

 public class Trie {
    private TrieNode _root;

    /** Initialize your data structure here. */
    public Trie() {
        _root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void Insert(string word) {
        TrieNode node = _root;
        foreach(char currentChar in word)
        {
            if(!node.ContainsKey(currentChar))
            {
                node.Insert(currentChar, new TrieNode());
            }
            node = node.Get(currentChar);
        }
        node.IsEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public bool Search(string word) {
        TrieNode node = SearchPrefix(word);
        return node != null && node.IsEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith(string prefix) {
        return SearchPrefix(prefix) != null;
    }

    private TrieNode SearchPrefix(string word)
    {
        TrieNode node = _root;

        foreach(char currentChar in word)
        {
            if(node.ContainsKey(currentChar))
            {
                node = node.Get(currentChar);
            }
            else
            {
                return null;
            }
        }
        return node;
    }
}

public class TrieNode
{
    private TrieNode[] _links;

    private const int R = 26;

    public TrieNode()
    {
        _links = new TrieNode[R];
    }

    public bool ContainsKey(char ch)
    {
        return _links[ch - 'a'] != null;
    }

    public TrieNode Get(char ch)
    {
        return _links[ch - 'a'];
    }

    public void Insert(char ch, TrieNode node)
    {
        _links[ch - 'a'] = node;
    }

    public bool IsEnd {get; set;}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */
