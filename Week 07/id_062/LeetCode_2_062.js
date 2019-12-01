/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    return n > 0 && (n & (n-1)) == 0;
};

var isPowerOfTwo = function(n) {
    return Number.isInteger(Math.log2(n));
};
