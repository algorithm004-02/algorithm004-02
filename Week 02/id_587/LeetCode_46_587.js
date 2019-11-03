/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */
// @lc code=start
/**
 * @param {number[][]} result 排列的最终结果，每次完成时递归中更新
 * @param {number[]} nums 输入用作排列的初始序列
 * @param {number[]} resultItem 已排列的结果，每次递归时都会更新
 * @param {number} index  当前要进行排列的resultItem的index
 * @return {number}
 * @description 每次递归时，从未被排列的值中，选取一个进行排列。后将排列结果resultItem传入下次递归，直到index与nums.length相同，表示当前resultItem的排列已完成，后将resultItem更新到result中。如此循环可得到最终结果。
 * @summary 尝试了完全不进行人肉递归，而是直接将问题分解成子问题进行求解，需要注意的是，每次递归都要过滤掉已排列的值。
 */
var recursion = function (result, // 排列的最终结果，每次完成时递归中更新
nums, // 输入用作排列的初始序列
resultItem, // 已排列的结果，每次递归时都会更新
index // 当前要进行排列的resultItem的index
) {
    // 当index === nums.length时，表示已经完成了本次resultItem的排列，可以更新result
    if (index === nums.length) {
        result.push(resultItem);
        return;
    }
    // 过滤掉已排列的值，用于为当前index位置选取结果
    var optionNums = nums.filter(function (num) {
        if (resultItem.length && resultItem.indexOf(num) >= 0) {
            return false;
        }
        return true;
    });
    // optionNums中的值，都可以作为当前index的值，因此要进行遍历，而每次产生的新resultItem，都可作为下一个index排列的初始值
    optionNums.forEach(function (option) {
        recursion(result, nums, [].concat(resultItem, [option]), index + 1);
    });
};
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
    var result = [];
    recursion(result, nums, [], 0);
    return result;
};
// @lc code=end
