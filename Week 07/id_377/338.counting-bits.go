/*
 * @lc app=leetcode id=338 lang=golang
 *
 * [338] Counting Bits
 *
 */

// @lc code=start


func countBits(num int) []int {
	res := make([]int, num+1)
	for i := 1; i <= num; i++ {
		// i>>1 == i/2
		// i&1  == i%2
		// 只是 位运算 更快
		//
		// 观察以下三个数的二进制表示
		// 5 : 101
		// 10: 1010, 10>>1 == 5
		// 11: 1011, 11>>1 == 5
		// 10 的二进制表示，含有 1 的个数，可以由 5 的答案 + 10%2 计算
		// 11 同理
		res[i] = res[i>>1] + i&1
	}
	return res
}


// /**
//  * @param {number} num
//  * @return {number[]}
//  */
//  var countBits = function(num) {
// 	var ans = Array(num + 1);
// 	for (var i = 0; i <= num; i++)
// 		ans[i] = hammingWeight(i);
  
// 	return ans;
//   };
  
//   var hammingWeight = function(n) {
// 	n = ((n & 0xAAAAAAAA) >>> 1) + (n & 0x55555555);
// 	n = ((n & 0xCCCCCCCC) >>> 2) + (n & 0x33333333);
// 	n = ((n & 0xF0F0F0F0) >>> 4) + (n & 0x0F0F0F0F);
// 	n = ((n & 0xFF00FF00) >>> 8) + (n & 0x00FF00FF);
// 	n = ((n & 0xFFFF0000) >>> 16) + (n & 0x0000FFFF);
// 	return n;
//   };

//   var countBits = function(num) {
// 	var ans = Array(num + 1);
// 	for (var i = 0; i <= num; i++)
// 		ans[i] = hammingWeight(i);
  
// 	return ans;
//   };
  
//   var hammingWeight = function(n) {
// 	n = ((n & 0xAAAAAAAA) >>> 1) + (n & 0x55555555);
// 	n = ((n & 0xCCCCCCCC) >>> 2) + (n & 0x33333333);
// 	n = ((n & 0xF0F0F0F0) >>> 4) + (n & 0x0F0F0F0F);
// 	n = ((n & 0xFF00FF00) >>> 8) + (n & 0x00FF00FF);
// 	n = ((n & 0xFFFF0000) >>> 16) + (n & 0x0000FFFF);
// 	return n;
//   };

// @lc code=end

