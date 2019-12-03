func relativeSortArray(arr1 []int, arr2 []int) []int {
    
    //check boundary
    
   // Fill the first arry item as index
    
    m := make([]int, 1001)
    
    result := make([]int, len(arr1))
    
    for _, value := range arr1 {
        m[value] ++
    }
    
    //count sort with arr2
    
    count:=0
    
    for _, value := range arr2 {
        
        for m[value] > 0 {
            
            result[count] = value
            count++
            
            m[value]--
            
        }
    }
    
    //find the max value and sort arr 1
    for i:=0; i< 1001; i++ {
        
        for m[i] > 0 {
            result[count] = i
            count++
            m[i]--
        }
        
    }
    
    return result
    
    
    
    
}