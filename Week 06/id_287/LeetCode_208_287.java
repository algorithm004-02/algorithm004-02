package com.tulane.leetcode.one;

/**
 * 实现Trie(前缀树)
 * Created by Tulane
 * 2019/11/24
 */
public class LeetCode_208 {

    /**
     * 定义TrieNode
     */
    class TrieNode {
        private TrieNode[] lines;

        private int R = 26;

        private boolean endFlag;

        public TrieNode() {
            lines = new TrieNode[R];
        }

        public boolean containKey(char ch){
            return lines[ch - 'a'] != null;
        }

        public TrieNode get(char ch){
            return lines[ch - 'a'];
        }

        public void put(char ch, TrieNode trieNode){
            lines[ch - 'a'] = trieNode;
        }

        public boolean getEndFlag() {
            return endFlag;
        }

        public void setEndFlag(boolean endFlag) {
            this.endFlag = endFlag;
        }
    }

    final private TrieNode trieNode;

    /** Initialize your data structure here. */
    public LeetCode_208() {
        trieNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = trieNode;
        char[] chArr = word.toCharArray();
        for (char ch : chArr) {
            if(!node.containKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        // 结束符, 表示此叶子节点为单词
        node.setEndFlag(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchLastNode(word);
        return node != null && node.getEndFlag();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchLastNode(prefix);
        return node != null;
    }

    private TrieNode searchLastNode(String word){
        TrieNode node = trieNode;
        char[] chArr = word.toCharArray();
        for (char ch : chArr) {
            if(!node.containKey(ch)){
                return null;
            }
            node = node.get(ch);
        }
        return node;
    }
}
