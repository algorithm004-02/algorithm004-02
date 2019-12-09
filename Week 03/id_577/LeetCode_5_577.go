func lemonadeChange(bills []int) bool {
    five, ten := 0, 0
    
    for _, value := range bills {
        
        if value == 5 {
            five++
            
        } else if value == 10 {
            ten++;
            five--;
            
        } else if ten > 0 {
            ten--
            five--
        } else {
            five = five -3
            
        }
        
        if five < 0 {
        return false
    }
        
    }
    
    
    
    return true
    
}