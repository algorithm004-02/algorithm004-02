class Solution {
    
    // eight directions : all 0's position can swap to.
    private  final int[][] dis = new int[][]{{1,3}, {0, 2, 4}, {1,5}, {0, 4}, {1,3, 5},  {2, 4}};
    
    //target string
    
    private final String target = "123450";
    public int slidingPuzzle(int[][] board) {
        
        //Check boundary
        int m  = board.length;
        if (m == 0 ){
            return 0;
        }
        
        int n = board[0].length;
        
        
        
        //Initialize: start string
        String start="";
        for(int i = 0;  i< m; i++ ){
            for(int j=0; j< n; j++){
                start += board[i][j];
            }
        }
        
        Queue<String> queue  = new  LinkedList();
        Set<String> visited = new HashSet();
        
        queue.offer(start);
        visited.add(start);
        
        int res = 0;
        
        //process
        while(!queue.isEmpty()){
            
            int size = queue.size();
            while(size-- >0){
                String current = queue.poll();
                
                //terminate
                
                if (current.equals(target)) {
                    return res;
                }
                
                //process current  with eight directions
                
                int index = current.indexOf("0");
                
                for (int d : dis[index]) {
                    
                    //swap
                    String next = swap(current, index, d);
                    
                    if (!visited.contains(next)) {
                      queue.offer(next);
                      visited.add(next);
                   }
                    
                }
            }
            
            res++;
           
        }
        return -1; 
        
    }
        
    
                        
      public String swap(String current, int index, int d) {
          
          StringBuilder sb = new StringBuilder(current);
          
          sb.setCharAt(index, current.charAt(d));
          sb.setCharAt(d, current.charAt(index));
          
          return sb.toString();
          
      }
}