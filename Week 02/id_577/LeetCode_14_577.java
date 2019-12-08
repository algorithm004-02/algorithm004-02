class Solution {
    
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        
        //
        
        int n = nums.length;
            
        backtrack( n, new ArrayList(), nums);
        
        return result;
        
    }
    
    public void backtrack(int n, List<Integer> curr,int[] nums){
        if (curr.size() == n) {
            
            result.add(new LinkedList(curr));
                
            return ;
            
        }
        
        for (int i = 0; i < n ; i ++) {
            
         //
            
            if (curr.contains(nums[i])) continue;
            
            curr.add(nums[i]);
            
            //backtrack
            
            backtrack(n, curr, nums);
            
            //remove 
                
          curr.remove(curr.size()-1);
            
        }
    }
}