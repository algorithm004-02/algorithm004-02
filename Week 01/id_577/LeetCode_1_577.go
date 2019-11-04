func removeDuplicates(nums []int) int {
    
    //Check bound
    if len(nums) == 0 {
        return 0
    }
    
    //Initialize two pointer i, and j; something like two pointer in container area
    i := 0
    
    for _, value := range nums {
        if nums[i] != value {
            i++
            nums[i] = value
        }
    } 
    
    return i + 1
    
}