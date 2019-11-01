const (
    water = '0'
    land  = '1'
)

func numIslands(grid [][]byte) int {
    islands := 0
    
    for i := 0; i< len(grid); i++ {
        for j := 0; j < len(grid[0]); j++ {
            if grid[i][j] == land {
                islands++
                fillWithWater(grid, i, j)
            }
        }
    }
    
    return islands
}

func fillWithWater(grid [][]byte, i, j int) {   
    // set itself to zero
    grid[i][j] = water
    
    // set > left zero
    if i - 1 >= 0 {
        if grid[i-1][j] == land {
            fillWithWater(grid, i-1, j)
        }
    }
    
    // set > right zero
    if i + 1 < len(grid) {
        if grid[i+1][j] == land {
            fillWithWater(grid, i+1, j)
        }
    }
    
    // set > down zero
    if j - 1 >= 0 {
        if grid[i][j-1] == land {
            fillWithWater(grid, i, j-1)
        }
    }
    
    // set > up zero
    if j + 1 < len(grid[0]) {
        if grid[i][j+1] == land {
            fillWithWater(grid, i, j+1)
        }
    }
}