/**
 * @param {number[]} nums
 * @return {number}
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @summary
 * 1. 审题时对题目理解不够清晰，未能充分理解“你不需要考虑数组中超出新长度后面的元素”的含义，刚开始还有思考如何去除后续元素。
 * 2. 执行结果如下：
 * 执行用时 : 112 ms, 在所有 javascript 提交中击败了55.03%的用户
 * 内存消耗 : 36.6 MB, 在所有 javascript 提交中击败了81.42%的用户
 * 对该结果不完全满意，希望能减少用时。
 * 3. 不太理解题目中“并在使用 O(1) 额外空间的条件下完成”描述的含义
 */

const removeDuplicates: (nums: number[]) => number = (nums: number[]) => {
  if (!nums.length) {
    return 0;
  }

  let saveIndex: number = 0; // 保存数据的Index

  for (let index = 0; index < nums.length; index++) {
    if (nums[index] !== nums[saveIndex]) {
      saveIndex++;
      nums[saveIndex] = nums[index];
    }
  }

  return saveIndex + 1;
};
