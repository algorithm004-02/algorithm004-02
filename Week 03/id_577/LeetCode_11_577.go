func jump(nums []int) int {
    
    max_pos := 0
    step := 0
    end :=0
    
    for i:= 0; i < len(nums) -1; i ++ {
        
        max_pos = max(max_pos, nums[i] + i)
        
        if i == end {
            end = max_pos
            step++
        }
        
        
    }
    
    
    return step
    
    
}

func max(x, y int) int {
    if x > y {
        return x
    }
    
    return y
}