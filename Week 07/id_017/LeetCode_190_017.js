
/**
 * 190.颠倒二进制位
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    //解法1: int 转成 string '0110', string -> int '1001'
    
    //解法2: 
    let result = 0;
    for(let i = 0;i < 32;i++){
        //左移生成结果
        result = (result << 1) + (n & 1);
        //再右移下一位数
        n >>= 1;
    }
    return result >>> 0;
};
