class Solution {
    private var count = 0
    private var size = 0
    func totalNQueens(_ n: Int) -> Int {
        size = (1 << n) - 1
        dfs(col: 0, ld: 0, rd: 0)
        return count
    }

    private func dfs(col: Int, ld: Int, rd: Int) {
        if col == size {
            count += 1
            return
        }

        var valid = (~(col | ld | rd)) & size
        while valid != 0 {
            var pos = valid & -valid
            valid -= pos
            dfs(col: (col | pos), ld: (ld | pos) >> 1, rd: (rd | pos) << 1)
        }
    }
}
