/*func canJump(nums []int) bool {
    
    last_pos := len(nums) - 1
    
    for i:= last_pos; i >= 0; i -- {
        
        if i + nums[i] >= last_pos {
            
            last_pos = i
            
        }
        
    }
    
    return last_pos == 0
    
}*/


func canJump(nums []int) bool {
    
    return jump(0, nums)
    
}

func jump(start int, nums []int)bool {
    
    if start == len(nums) -1 {
        return  true
    }
    
    further_jump := min(start + nums[start], len(nums) -1)
    
    for next_pos := further_jump; next_pos > start; next_pos-- {
        
        return jump(next_pos, nums)
        
    }
    
    return false
}

func min (x, y int)int {
    if x < y {
        return x
    }
    
    return y
}