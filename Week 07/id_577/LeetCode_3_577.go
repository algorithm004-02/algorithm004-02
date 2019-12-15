func reverseBits(num uint32) uint32 {
    
    result := 0
    
    for i:=0; i< 32; i++ {
        result <<= 1
        
        if num&1 == 1 {
            result++
        }
        
        num >>= 1
    }
    
    return (uint32)(result)
    
}