/*难点->最后一个既然是和第一个相连的，不然一个动态规划等式就能解决了
     * dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
     * 突破这个难点，使用两个规划数组，一个从0开始，n-1结束，另一个从1开始，n结束
     * 求出两个数组的最大值
     
     Refer to https://leetcode.com/problems/house-robber-ii/discuss/59934/Simple-AC-solution-in-Java-in-O(n)-with-explanation

*/


func rob(nums []int) int {
    
    if len(nums) == 0  {
        return 0
    }
    
    if len(nums) ==  1 {
        return nums[0]
    }
    
    return max(rob_recursive(nums, 0, len(nums) -1), rob_recursive(nums, 1, len(nums)))
    
   
    
    
}

func rob_recursive(nums []int, start int, end int)int{
    dp_pre :=0
    dp_curr :=0
    
    for i:= start ; i< end; i++ {
        temp := dp_curr
        
        dp_curr = max(dp_curr, dp_pre+nums[i])
        
        dp_pre = temp
    } 
    
    return dp_curr
}

func max(x, y int )int{
    if x > y  {
        return x
    }
    
    return y
}