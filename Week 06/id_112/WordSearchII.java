package datastruct.trieTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 212.单词搜索 II
 *
 *
 给定一个二维网格 board 和一个字典中的单词列表 words，
 找出所有同时在二维网格和字典中出现的单词。
 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 同一个单元格内的字母在一个单词中不允许被重复使用。

 示例:
 输入:
 words = ["oath","pea","eat","rain"] and board =
 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]

 输出: ["eat","oath"]
 说明:
 你可以假设所有输入都由小写字母 a-z 组成。

 *
 */
public class WordSearchII {

    /**
     * 1、words 遍历 --> board search
     *  O(N*m*m*4^k)
     *
     * 2、trie
     * a. all words --> Trie 构建起prefix
     * b. borad,DFS
     *
     */
    public List<String> findWords(char[][] board, String[] words) {
        // 构建字典树
        WordTrie myTrie = new WordTrie();
        TrieNode2 root = myTrie.root;
        for (String s:words)
            myTrie.insert(s);

        //使用set防止重复
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        //遍历整个二维数组
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                find(board,visited,i,j,m,n,result,root);
            }
        }
        System.out.println(result);
        return new LinkedList<String>(result);
    }


    private void find(char[][] board,boolean[][] visited
            ,int i,int j,int m,int n,Set<String> result,TrieNode2 cur) {
        //边界以及是否已经访问判断
        if (i<0 || i>= m || j<0 || j>=n || visited[i][j])
            return;
        cur = cur.child[board[i][j]-'a'];
        visited[i][j] = true;
        if (cur == null)
        {
            // 如果单词不匹配，回退
            visited[i][j] = false;
            return;
        }
        // 找到单词加入
        if (cur.isLeaf) {
            result.add(cur.val);
            //找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
//            visited[i][j]=false;
//            return;

        }
        find(board,visited,i+1,j,m,n,result,cur);
        find(board, visited, i, j + 1, m, n, result, cur);
        find(board,visited,i,j - 1,m,n,result,cur);
        find(board,visited,i - 1,j,m,n,result,cur);
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j] = false;
    }


}