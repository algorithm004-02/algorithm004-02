package com.study.week6.lesson13;

public class LeetCode_208_482 {

}
class Trie {
    private class TrieNode {
        char val;
        boolean isWord;
        TrieNode [] children =new TrieNode[26];
        public TrieNode(){};
        public TrieNode(char c) {
            TrieNode node=new TrieNode();
            node.val=c;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
        root.val=' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char [] arr=word.toCharArray();
        TrieNode curr=root;
        for (int i=0;i<arr.length;i++) {
            if (curr.children[arr[i] - 'a'] == null) {
                curr.children[arr[i] - 'a']=new TrieNode(arr[i]);
            }
            curr=curr.children[arr[i] - 'a'];
        }
        curr.isWord=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char [] arr=word.toCharArray();
        TrieNode curr=root;
        for (int i=0;i<arr.length;i++) {
            if (curr.children[arr[i] - 'a'] == null) {
                return false;
            }
            curr=curr.children[arr[i] - 'a'];
        }

        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char [] arr=prefix.toCharArray();
        TrieNode curr=root;
        for (int i=0;i<arr.length;i++) {
            if (curr.children[arr[i] - 'a'] == null) {
                return false;
            }
            curr=curr.children[arr[i] - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
