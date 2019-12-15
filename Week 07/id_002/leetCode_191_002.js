/** 191. 位1的个数 */

// 1. for loop 0 ---> 32
// 2. %2,  /2
// 3. &1, x = x >> 1;
// 4. while(x > 0) c++ x = x & (x - 1)

/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count = 0;
    
    for (let i = 0; i < 32; i ++) {
        if (n & 1) count ++;
        n = n >> 1;
    }

    return count;
};

/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count = 0;

    while(n != 0) {
        count ++;
        n &= (n - 1);
    }

    return count;
};

/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let str = n.toString(2);
    let count = 0; 
    for (let i = 0; i < str.length; i ++) {
        if (str[i] == 1) count ++;
    }

    return count;
};
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count = 0;
    
    while(n) {
        let res = n % 2;
        if (res === 1) count ++;
        n = n / 2 | 0;
    }

    return count;
};