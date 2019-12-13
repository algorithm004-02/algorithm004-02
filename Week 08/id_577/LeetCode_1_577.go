func lengthOfLIS(nums []int) int {
    
    //check boundayr
    
    n := len(nums)
    
    if n == 0 {
        return 0
    }
    
    //process
    
    tail := make([]int, n)
    
    end := 0
    
    for _, num := range nums {
        
        //binary search from left bound
        
        left := 0
        
        right := end 
        
        for left < right {
            
            mid := left + ((right - left) >> 1) 
            
            if tail[mid] < num {
                
                left = mid +1
                
            } else {
                
                right = mid
            }
            
            
        }
        
        tail[left] = num
        
        if end == right {
            end++
        }
        
    }
    
    return end
    
    
    
    
    
}