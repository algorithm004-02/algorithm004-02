/** 367. 有效的完全平方数 **/
/**
 * 暴力解法
 * 时间复杂度O(n) 空间复杂度O(1)
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
    if (num == 1) return true;
    
    for (let i = 0; i < num; i++) 
        if (i * i == num) return true;
        
    return false;
};

/**
 * 二分查找 
 * 时间复杂度 O(logn) 空间复杂度O(1)
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare2 = function(num) {
    if (num == 1) return true;
    
    let left = 0;
    let right = num;
    while(left < right) {
        let mid = Math.floor((left + right) / 2);
        if (mid * mid == num) {
            return true;
        } else if (mid * mid > num) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return false;
};

/**
 * 牛顿迭代法
 * 空间复杂度O(1)
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare3 = function(num) {
    let r = num; 
    while(r * r > num)
        r = (r + num / r) / 2 | 0;     
    return r*r === num;
};