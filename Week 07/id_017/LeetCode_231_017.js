
/**
 * 231.2的幂
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    // 2的幂数的数字的二进制有且只有一个1，其余均是0
    // 位运算 n & (n-1)：清零最低位的1
    // 合起来 n & (n-1) == 0
    return n > 0 && (n & (n-1)) == 0;

};