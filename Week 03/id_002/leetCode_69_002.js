/** 69. x 的平方根 */
/**
 * 二分查找
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    if (x === 0 || x === 1) {
        return x;
    }
    
    let left = 0;
    let right = x;
    
    while (Math.floor(right) - Math.floor(left) != 0) {
        let mid = left + (right - left) / 2;
        
        if (mid * mid == x) {
            return mid;
        } else if (mid * mid > x) {
            right = mid;
        } else {
            left = mid;
        }
    }
    
    return Math.floor(right);
};

/**
 * 牛顿迭代法
 * @param {number} x
 * @return {number}
 */
var mySqrt2 = function(x) {
    let r = x;
    while (r*r > x)
        r = ((r + x/r) / 2) | 0;
    return r;
};