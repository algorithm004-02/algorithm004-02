class Solution {
    public int[][] merge(int[][] intervals) {
        
        //Check boundary
        
        if (intervals.length == 0) {
            return new int[][] {};
        }
        
        
        
        //Initialize
        
        List<int[]> result = new ArrayList<>();
        
        //First sort the first column of each row
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        //If a[1] >= b[0], means overlap. Compare row by row
        int i =0;
        
        while( i< intervals.length) {
            int left = intervals[i][0];
                
            int right = intervals[i][1];
            
            //compare with next row
            while ( i< intervals.length -1 && intervals[i+1][0] <= right) {
                i++;
                
                right = Math.max(right, intervals[i][1]);
                
                
            }
            
            result.add(new int[]{left, right});
            i++;
        }
        
        return result.toArray(new int[0][]);
        
        
        
        
        
    }
}