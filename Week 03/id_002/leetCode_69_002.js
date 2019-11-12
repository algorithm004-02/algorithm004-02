/** 69. x 的平方根 */
/**
 * 二分查找
 * @param {number} x
 * @return {number}
 */
/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    let left = 0;
    let right = x;
    
    while(left <= right) {
        let mid = (left + right) / 2 | 0;
        
        if (mid * mid < x) {
            left = mid + 1;
        } else if (mid * mid > x) {
            right = mid - 1;
        } else {
            return mid;
        }
    }
    
    return right;
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