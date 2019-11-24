# 212. [单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)

## 题目

给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

==示例==

```
输入: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]
```

==说明:==

你可以假设所有输入都由小写字母 a-z 组成。

## 字典树 + DFS

> 先将单词转化为字典树，然后 DFS 遍历

```
class Solution {
    int rows, columns;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    Set <String> result =new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words.length == 0) {
            return new LinkedList<String>(result);
        }
        rows = board.length;
        columns = board[0].length;
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                dfs(board, i, j, "", trie.root);
            }
        }

        return new LinkedList<String>(result);
    }

    private void dfs(char[][] board, int i, int j, String word, TrieNode node) {
        String curWord = word + board[i][j];
        TrieNode curNode = node.get(board[i][j]);
        if (curNode != null && curNode.isEnd()) {
            result.add(curWord);
        }
        char temp = board[i][j];
        board[i][j] = '@';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < rows && y >= 0 && y < columns && 
            board[x][y] != '@' && curNode != null) {
                dfs(board, x, y, curWord, curNode);
            }
        }
        board[i][j] = temp;
    }
}

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
    public TrieNode root;
    
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
}
```


