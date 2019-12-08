class Solution {
    func findWords(_ board: [[Character]], _ word: [String]) -> [String] {
        if board.isEmpty || (board.first?.isEmpty ?? true) || words.isEmpty { return [] } 

        // build trie 
        let trie = TrieNode()
        for word in words {
            var node: TrieNode? = trie
            for char in word {
                if node?.children[char] == nil {
                    node?.children[char] = char
                }
                node = node?.children[char]
            }
            node?.word = word
        }

        // DFS
        var result = Set<String>()
        for i in 0..<board.count {
            for j in 0..<board[0].count {
                dfs(&board, i, j, trie, &result)
            }
        }
    }

    func dfs(_ board: inout [[Character]], _ i: Int, _ j: Int, _ node: TrieNode, result: inout Set<String>) {
        let char = board[i][j]
        if char == Character("#") || node.children[char] == nil { return }
        let node = node.children[char]
        if let word = node.word {
            result.insert(word)
            node.word = nil
        }

        board[i][j] = Character("#")
        for (dx, dy) in [(1, 0), (-1, 0), (0, 1), (0, -1)] {
            let row = i + dy
            let column = j + dx
            if let node = node, row >= 0 && row < board.count && column >= 0 && column < board[0].count {
                dfs(&board, row, column, node, &result)
            }
        }
        board[i][j] = char
    }

    class TrieNode {
        var children: [Character: TrieNode] = [:]
        var word: String?
    }
}
