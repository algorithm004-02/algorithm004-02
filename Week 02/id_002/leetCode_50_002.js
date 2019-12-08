/** 50. Pow(x, n) */

/**
 * 暴力解法
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    let res = 1;
    if (n < 0) {
        x = 1 / x;
        n = -n;
    }
    
    for (let i = 0; i < n; i++) {
        res = res * x
    }
    
    return res;
};

/**
 * 快速幂算法（递归）
 * 时间复杂度 O(logn)
 * 空间复杂度 O(logn)
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow2 = function(x, n) {
    if (n < 0) {
        n = - n;
        x = 1 / x;
    }
    return fastPow(x, n);
    function fastPow(x, n) {
        if (n <= 1) return 1;
        let half = fastPow(x, Math.floor(n / 2));
        return n % 2 === 0 ? half * half : half * half * x;
    }
};