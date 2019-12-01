class TrieNode {
    
    private TrieNode[] links;
    private final int R = 26;
    
    private boolean isEnd = false;
    
    public TrieNode() {
        
        links = new TrieNode[R];
        
    }
    
    public void setEnd() {
       isEnd = true;
    }
    
    public boolean getEnd() {
        return isEnd;
    }
    
    public boolean containsKey(char ch) {
        return links[ch - 'a']  != null;
    }
    
    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }
    
    public TrieNode get(char ch) {
        
        return links[ch-'a'];
        
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
        
        for (int i  = 0; i < word.length(); i++) {
            
            char current  = word.charAt(i);
            
            if (!node.containsKey(current)) {
                
                node.put(current, new TrieNode());
            }   
                
            node = node.get(current);
        
            
        }
        node.setEnd();
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        
        TrieNode node = searchPrefix(word);
        
        return node != null  && node.getEnd();
    }
                
    /** Returns if the word is in the trie. */
    public TrieNode searchPrefix(String word) {
        
        TrieNode node = root;
        
        for (int i  = 0; i < word.length(); i++) {
            
            char current  = word.charAt(i);
            
            if (!node.containsKey(current)) {
                
                return null;
            } else {
                node = node.get(current);
            }  
                
           
        
            
        }
                
                return node;
        
        
        
    }
                
      
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode node =  searchPrefix(prefix);
        return node != null;
        
        
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */