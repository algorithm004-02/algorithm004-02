class Solution {
    
    private int[][] distance = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1},{1, 1}, {-1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        //Check boundary
        int m = grid.length;
        
        if (m == 0) {
            return 0;
        }
        
        int n = grid[0].length;
        
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;//don't forget
        
        //Initialize
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList();
        
        queue.offer(new int[]{0, 0});//the last one is the answer.
        visited[0][0] = true;
        int result = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- > 0) {
                int[] current = queue.poll();
                
                /*Termiate */
                if (current[0] == m -1 && current[1] == n-1) {
                    return  result + 1 ;
                    
                }
                
                // Eight directions
                
                for (int[] d : distance){
                    
                    int  i = current[0] + d[0];
                    int j = current[1] + d[1];
                    
                    if (i >= 0 && i<m && j >=0 && j< n && grid[i][j] == 0 && !visited[i][j] ) {
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                        
                    }
                }
                
                
            }
            result++;
            
        }
        
        
        return -1;
        
        
    }
}