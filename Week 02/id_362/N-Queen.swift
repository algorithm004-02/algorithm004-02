class Solution {
    private var output: [[String]] = []
    private var queen: [Int] = []
    private var xyDiff: Set<Int> = []
    private var xySum: Set<Int> = []
    private var n: Int = 0

    func solveNQueens(_ n: Int) -> [[String]] {
        self.n = n
        backtrace(row: 0)
        return output
    }

    private func backtrace(row: Int) {
        if row >= n {
            output.append(format(queen))
            return
        }
        for col in 0..<n where !isUnderAttack(row: row, col: col) {
            queen.append(col)
            xyDiff.insert(row - col)
            xySum.insert(row + col)
            backtrace(row: row + 1)
            queen.removeLast()
            xyDiff.remove(row - col)
            xySum.remove(row + col)
        }
    }

    private func isUnderAttack(row: Int, col: Int) -> Bool {
        return queen.contains(col) || xyDiff.contains(row - col) || xySum.contains(row + col)
    }

    private func format(_ positions: [Int]) -> [String] {
        return positions.map { (col) -> String in
            String(
                Array<Character>(repeating: ".", count: col)
                    + [Character("Q")]
                    + Array<Character>(repeating: ".", count: n - col - 1))
        }
    }
}