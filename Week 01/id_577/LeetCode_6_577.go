func moveZeroes(nums []int)  {
    
    //Find the non-zero 
    
    i := 0
    
    for _, value := range nums {
        if value != 0 {
            nums[i] = value
            i ++ 
        }
        
    }
    
    for( i < len(nums)) {
        nums[i] = 0
        i++
        
    }
    
    
}