var output [][]int


func combine(n int, k int) [][]int {
    
    output = [][]int{}
    
    backtrack(1, []int{}, k , n)
    
    return output
    
    
}

func backtrack(first int, curr []int, k int,  n int) {
    
    if len(curr) == k {
        
        temp := make([]int, k)
		copy(temp, curr)
		
        
        output = append(output, temp)
        
        
        return 
    }
    
    //put value in curr
    for i := first; i<= n ; i ++  {
        
        curr = append(curr, i)
        
        backtrack(i + 1, curr, k, n)
    
        //remove last from curr.
        curr = curr[:(len(curr) -1)]
        
    }
    
       
    
    
    
}