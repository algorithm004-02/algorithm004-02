

/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    //自己一开始写的没考虑到 9->0 这种情况
    // for(let i = 0; i < digits.length; i++) {
    //     if(i = digits.length - 1){
    //         digits[i] += 1; 
    //     }
    // }
    // return digits;
    
    // 存储下来，做位数超出原来的计算的
    let n = digits.length;
    //从后面开始算
    for(let i = digits.length - 1; i >= 0; i--) {
        //因为是循环，只要是小于9，就加一
        if(digits[i] < 9) {
           digits[i]++;
           return digits;
        }
        
        // 等于 9 的就加1 = 0
        digits[i] = 0;
    }
    
    //后面的数都是0了，才会走到这一步
    // 1000000
    
    
    return [1,...digits];
};