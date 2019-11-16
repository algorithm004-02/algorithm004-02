public class Solution {
    
    // DFS using recursion
    public int NumIslands(char[][] grid) {
        
        if( grid==null ) return 0;
        if( grid.Length==0 || grid[0].Length==0) return 0;
        
        int numIslands=0;
        for(int i=0; i<grid.Length; i++)
        {
            for(int j=0; j<grid[0].Length; j++)
            {
                if(grid[i][j]=='1')
                {
                    numIslands+=1;
                    //DFS using recursion
                    DFS(grid,i,j);
                }
            }
        }
        
        return numIslands;
    }
    
    private void DFS(char[][] grid, int i, int j)
    {
            grid[i][j]='0';
            
            int left=i-1;
            int right=i+1;
            int up=j-1;
            int down=j+1;
            
            
            if(left>=0 && grid[left][j]=='1') { 
                grid[left][j]='0';
                DFS(grid,left,j); 
            }
            
            if(right<grid.Length && grid[right][j]=='1') { 
                grid[right][j]='0';
                DFS(grid,right,j); 
            }
            
            if(up>=0 && grid[i][up]=='1') { 
                 grid[i][up]='0';
                 DFS(grid,i,up);
            }
            
            if(down<grid[0].Length && grid[i][down]=='1') { 
                grid[i][down]='0';
                DFS(grid,i,down);
            }
    }
}