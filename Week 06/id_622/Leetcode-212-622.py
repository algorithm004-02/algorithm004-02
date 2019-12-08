"""
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

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

提示:

你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0]:
            return []
        if not words:
            return []
        
        result = set()
        
        trie = {}
        for word in words:
            t = trie
            for w in word:
                t = t.setdefault(w, {})
            t["end"] = '#'
            
        m = len(board)
        n = len(board[0])
        
        def dfs(i, j, board, cur_word, cur_dict, visited):
            cur_word += board[i][j]
            if 'end' in cur_dict:
                result.add(cur_word)
                # return 此处用return以后导致后续还有单词无法工作，比如找到oaa, 后续还有oaab
            
            directions = ((-1, 0), (1, 0), (0, -1), (0, 1))
            for (x, y) in directions:
                _x, _y = x + i, y + j
                if 0 <= _x < m and 0 <= _y < n and board[_x][_y] in cur_dict and (_x, _y) not in visited:
                    # dfs(_x, _y, board, cur_word, cur_dict[board[_x][_y]], visited.add((_x, _y)))
                    # TypeError: argument of type 'NoneType' is not iterable
                    dfs(_x, _y, board, cur_word, cur_dict[board[_x][_y]], visited | {(_x, _y)})
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] in trie:
                    dfs(i, j, board, '', trie[board[i][j]], {(i, j)})
        return list(result)
        
        
        