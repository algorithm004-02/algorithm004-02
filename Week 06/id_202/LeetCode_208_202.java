package com.algorithm.qinchao.homework.week06;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/20 13:40
 * @description 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_208_202 {
    class Trie {
        TrieNode root;

        class TrieNode {
            private TrieNode[] nodes;
            private int R = 26;
            private boolean isEnd;

            /**
             * Initialize your data structure here.
             */
            public TrieNode() {
                nodes = new TrieNode[R];
            }

            public void setEnd(boolean isEnd) {
                this.isEnd = isEnd;
            }

            public TrieNode get(char ch) {
                return nodes[ch - 'a'];
            }

            public boolean containsKey(char ch) {
                return nodes[ch - 'a'] != null;
            }

            public void put(char ch, TrieNode node) {
                nodes[ch - 'a'] = node;
            }
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd(true);

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char curLetter = prefix.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }
}
