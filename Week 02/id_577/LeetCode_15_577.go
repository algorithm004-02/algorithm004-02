/*
Use iteration and loop

But if n is too large , it may be timeout.

func myPow(x float64, n int) float64 {
    N := int64(n)
    
    //If decimal 
    
    if N < 0 {
        x = 1/x
        N = -N
    }
    
    res := float64(1)//attention, must be float64 ,otherwise, its accuracy will result incorrect result.
    
    for i:= int64(0); i < N ; i ++ {
        
        res = res * x
        
    }
    
   
    return res 
    
    //return pow(x, int64(n))
    
    
}*/

func myPow(x float64, n int) float64 {
    
     N := int64(n)
    
    //If x is less than 0, must consider it.
    
    if N < 0 {
        x = 1/x
        N = -N
    }
    
    return half_pow(x, N)
    
    
    
}

func half_pow(x float64, n int64) float64 {
    if n == 0 {
        return 1
    }
    
    half := half_pow(x, n/2)
    
    if n % 2 == 0  {
        
        
        return half * half
        
        
    } else {
        
        return half *  half *  x
        
        
    }
    
    
}