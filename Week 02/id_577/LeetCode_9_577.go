func generateParenthesis(n int) []string {
    result := []string{}
    
    result = generate(0, 0, n, "")
    
    return result
    
    
}

func generate(left int,  right int,  max int, s string ) []string{
    
    result := []string{}
    if left == max && right == max {
        
        result = append(result, s)
        
    }
    
    if left < max {
        result = append(result, generate(left +1, right, max, s+"(")...)
        
    }
    
    if left > right {
        
        result = append(result, generate(left, right + 1, max, s+")")...)
        
    }
    
    return result
    
}