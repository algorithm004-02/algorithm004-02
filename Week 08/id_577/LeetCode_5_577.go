func reverseStr(s string, k int) string {
    
    //check boundary
    n := len(s)
    
    if n *k  == 0 {
        
        return ""
        
    }
    
    arr := []byte(s)
    
    for start := 0; start< n ; start += 2 * k {
        
        end := min(start + k -1, n - 1)//
        
        reverse(arr, start, end)
    }
    
    return string(arr)
    
    
    
}

//use the reverse from reverse string 1

func reverse(arr []byte, left int,right int){
    
    
    for (left < right){
        
        arr[left] , arr[right] = arr[right], arr[left]
        
        left++ 
        
        right--
        
        
        
    }
}

func min(x, y int) int {
    
    if x < y {
        return x
    }
    
    return y
    
}