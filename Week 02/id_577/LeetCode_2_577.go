/*func twoSum(nums []int, target int) []int {
    
    //Brutal force
    
    for i:=0; i < len(nums); i ++ {
        for j := i + 1; j < len(nums); j ++ {
            if (nums[i] + nums[j] == target) {
                return []int{i , j} 
            }
        }
    }
    
    return []int{}
    
}*/

func twoSum(nums []int, target int) []int {
    //use hash set
    
    resultMap := make(map[int]int)
    
    
    for index:=0; index <len(nums);index ++ {
        resultMap[nums[index]] = index
        
    }
    
    
    for index:=0; index < len(nums); index ++ {
        
      
        complement := target -nums[index]
       
        if resultMap[complement] >= 0 && resultMap[complement] != index {
            return []int{resultMap[complement], index}
            
            
        }
        
       
    }
    
    return []int{}
}