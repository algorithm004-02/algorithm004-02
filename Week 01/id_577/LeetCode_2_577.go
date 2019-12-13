func rotate(nums []int, k int)  {
    
    result := make([]int, len(nums))
    
    for i:= 0; i < len(nums);  i++  {
        result[(i + k) % (len(nums))] = nums[i]
    }
    
    for index, value := range result {
        nums[index] = value
    }
    
}