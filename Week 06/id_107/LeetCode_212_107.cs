/*
    212. 单词搜索 II
    给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 */

public class Solution
{
    public List<string> FindWords(char[][] board, string[] words)
    {
        //构建字典树
        WordTrie myTrie = new WordTrie();
        TrieNode root = myTrie.root;
        foreach (string word in words)
        {
            myTrie.Insert(word);
        }

        //使用set防止重复
        HashSet<string> result = new HashSet<string>();
        int m = board.Length;
        int n = board[0].Length;
        bool[,] visited = new bool[m, n];

        //遍历整个二维数组
        for (int i = 0; i < board.Length; i++)
        {
            for (int j = 0; j < board[0].Length; j++)
            {
                Find(board, visited, i, j, m, n, result, root);
            }
        }

        return new List<String>(result);
    }

    private void Find(char[][] board, bool[,] visited, int i, int j, int m, int n, HashSet<string> result, TrieNode cur)
    {
        //边界以及是否已经访问判断
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i, j]) return;

        cur = cur.child[board[i][j] - 'a'];
        visited[i, j] = true;

        if (cur == null)
        {
            //如果单词不匹配，回退
            visited[i, j] = false;
            return;
        }
        //找到单词加入
        if (cur.IsLeaf)
        {
            result.Add(cur.Val);
            //找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
            //            visited[i][j]=false;
            //            return;
        }
        Find(board, visited, i + 1, j, m, n, result, cur);
        Find(board, visited, i, j + 1, m, n, result, cur);
        Find(board, visited, i, j - 1, m, n, result, cur);
        Find(board, visited, i - 1, j, m, n, result, cur);

        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i, j] = false;
    }

    class WordTrie
    {
        public TrieNode root = new TrieNode();
        public void Insert(String s)
        {
            TrieNode cur = root;
            foreach (char c in s)
            {
                if (cur.child[c - 'a'] == null)
                {
                    cur.child[c - 'a'] = new TrieNode();
                    cur = cur.child[c - 'a'];
                }
                else
                {
                    cur = cur.child[c - 'a'];
                }
            }
            cur.IsLeaf = true;
            cur.Val = s;
        }
    }


    class TrieNode
    {
        public String Val { get; set; }
        public TrieNode[] child = new TrieNode[26];
        public bool IsLeaf { get; set; }
    }
}


