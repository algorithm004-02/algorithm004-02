import Foundation

extension Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        var grid = grid
        if grid.isEmpty || grid.first?.isEmpty ?? true { return 0 }
        for i in 0...grid.count {
            for j in 0...grid[0].count {
                if i == 0 && j == 0 { continue }
                else if i == 0 { grid[i][j] = grid[i][j-1] + grid[i][j] }
                else if j == 0 { grid[i][j] = grid[i-1][j] + grid[i][j] }
                else { grid[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j] }
            }
        }
        return grid[grid.count - 1][grid[0].count - 1]
    }
}
