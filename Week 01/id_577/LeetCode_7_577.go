/**
There are 3 test cases:
1. 不进位
2、进位
3、进位并且增加一位

*/
func plusOne(digits []int) []int {
    
    for i := len(digits) -1; i >=0; i -- {
        digits[i] ++
        digits[i] = digits[i] % 10
        //Case 1 and 2
        if digits[i] !=0 {
            return digits
        }
    }
    
    //Case 3:
    
    new_digits := make([]int, len(digits) + 1)
    
    new_digits [0] =1
    return new_digits
  
}