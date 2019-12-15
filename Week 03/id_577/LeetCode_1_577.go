const(
mine = 'M'
blank = 'B'
empty = 'E'
find = 'X'
)   

var dx []int

var dy []int

var row int
var col int

func updateBoard(board [][]byte, click []int) [][]byte {
    
    x, y := click[0], click[1]
    
    dx = []int{-1, -1, -1, 0, 0, 1, 1, 1 }
    dy = []int{ 1, 0, -1,  1,-1, 1, 0, -1}
    
    row = len(board)
    col = len(board[0])

    
    if board[x][y] == mine {
        board[x][y] = find
        return board
    }
    
    DFS(board, x, y )
    
    return board
    
    
    
}


func DFS(board [][]byte, x int,  y int) {
    
    // check the boundary
    
    
    
    if x >= row || y >= col || x < 0 || y < 0 || board[x][y] != empty {
        return 
    }
    
    
    num := findNumsOfBomb(board, x, y)
    
    if num == 0 {
        board[x][y] = blank
        
        //change all its adjacent 8 recusively
        
        for i:=0; i < 8; i++ {
            nx, ny := x + dx[i], y +dy[i]
            DFS(board, nx, ny)
        }
        
     
        
    } else {
        
       /// If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines
       
        
        
        board[x][y] = '0' + byte(num)
        
        
        
        
        
    }
        
        
    
    
    
    
    
}

func findNumsOfBomb(board [][]byte, x int, y int) int{
    
    //Find 8 neighbors
    
    nums := 0
    
    for i:=0; i < 8; i ++ {
        
        nx, ny := x + dx[i], y +dy[i]
        
        if nx < 0 || ny < 0 || nx >= row || ny >= col {
            continue
        }
        
        if board[nx][ny] == mine || board[nx][ny] == find {
            nums++
        }
        
        
    }
    
    return nums
    
}
    
    
    
                                                              
                                                        
                                                         