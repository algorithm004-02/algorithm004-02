/*
 * @lc app=leetcode id=231 lang=golang
 *
 * [231] Power of Two
 * 
 */

// @lc code=start


func isPowerOfTwo(n int) bool {
	if n < 1 {
		return false
	}

	for n > 1 {
		if n%2 == 1 {
			return false
		}
		n /= 2
	}

	return true
}

 
//  var isPowerOfTwo = function(n) {
// 	var tmp = ~~(Math.log(n) / Math.log(2));
// 	return n === (1 << tmp);
//   };

/* class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n != 0 and (n & -n) == n */

// @lc code=end

