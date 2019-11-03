/*Brutal force
func isAnagram(s string, t string) bool {
    
    return sortString(s) == sortString(t)
   
}

func sortString(s string) string{
    
    v := strings.Split(s, "")
    sort.Strings(v)
    
    return strings.Join(v, "")
    
}*/

/** Use hash to store each char count */

func isAnagram(s string, t string) bool {
    
    if len(s) != len(t) {
        return false
    }
    
    count :=make(map[rune]int, 26)
    
    for _, char := range s{
        count[char]++
        
    }
    
    for _, char := range t {
        count[char] --;
    }
    
    for _, value := range count {
        if value !=0 {
            return false
        }
    }
    
    return true
    
    
   
}