/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

//  方法一：暴力求解 时间复杂度 O(n^2)
// var twoSum = function (nums, target) {
//   for (var i = 0; i < nums.length; i++) {
//     for (var j = i + 1; j < nums.length; j++) {
//       if (nums[i] + nums[j] == target) {
//         return [i, j]
//       }
//     }
//   }
// };

// 方法二：循环一次数组，判断另一个数是否存暂存的变量中 O(n)
// var twoSum = function (nums, target) {
//   let map = {};
//   // 循环 nums
//   for(let i = 0; i < nums.length; i++) {  
//     let anotherNumber = target - nums[i]; // 获取到另一个值
//     if(anotherNumber in map) {  // 判断另一个值是否在创建的map对象中， 如果存在则返回它的坐标，和当前数字的坐标数组
//       return [map[anotherNumber], i]
//     } else { // 如果不存在则把这个值和地址存入对象中
//       map[nums[i]] = i;
//     }
//   }
// };

// 方法三：与二一样，但不自己手动构建map
var twoSum = function (nums, target) {
  const map = new Map();
  for(let i = 0; i < nums.length; i++) {  
    const otherIndex = map.get(target - nums[i]); // 获取到另一个值
    if(otherIndex !== undefined) {  // 判断另一个值是否在创建的map对象中， 如果存在则返回它的坐标，和当前数字的坐标数组
      return [otherIndex, i]
    } else { // 如果不存在则把这个值和地址存入对象中
      map.set(nums[i], i);
    }
  }
};
// @lc code=end