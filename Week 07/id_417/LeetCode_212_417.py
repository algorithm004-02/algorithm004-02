class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        if not board or not board[0] or not words:
            return []
        
        root = {}
        
        # 构建trie树
        for word in words:
            node = root
            for w in word:
                if w not in node:
                    node[w] = {}
                node = node[w]
            
            node["#"] = "#"
        
        m, n = len(board), len(board[0])
        result = []
        
        # dfs
        def _dfs(i, j, node, pre, visited):
            # 终止条件
            if "#" in node and pre not in result:
                result.append(pre)
                
            for (di, dj) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                _i, _j = i+di, j+dj
                
                if -1 < _i < m and -1 < _j < n and board[_i][_j] in node and (_i, _j) not in visited:
                    _dfs(_i, _j, node[board[_i][_j]], pre+board[_i][_j], visited | {(_i, _j)})
        
        for i in range(m):
            for j in range(n):
                if board[i][j] in root:
                    _dfs(i, j, root[board[i][j]], board[i][j], {(i, j)})
            
        return result
