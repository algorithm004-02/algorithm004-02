/**  */
// 1. 位移 + 拼接
// 2. 位移 + 换位

/**
 * 1. 位移 + 拼接
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    let res = 0; 
    for (let i = 0; i < 32; i ++) {
        res = (res << 1) + (n & 1);
        n >>= 1;
    }

    // 转换为无符号整型
    return res >>> 0; 
};

/**
 * 2. 位移 + 换位
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    let res = 0;
    for(let i = 0; i < 32; i ++) {
        res <<= 1;
        res |=  n & 1;
        
        n >>= 1;
    }

    return res >>> 0;
};

/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    let i = 0, j = 31, val = 0, temp = 0;

    while(i < j) {
        temp = n >> i; 
        temp &= 1;
        temp <<= j;
        val |= temp;  
        
        temp = n >> j;
        temp &= 1;
        temp <<= i;
        val |= temp;

        i ++;
        j --;
    }

    return val >>> 0;
};