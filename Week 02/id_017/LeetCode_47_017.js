
/**
 * 47.全排列II
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
/**
 * Time: O(n * n!)
 * Space: O(n * n!)
 * n - # of nums
 */

    const solutions = [];
    nums.sort((a, b) => a - b);
    findPermutations(nums, solutions, [], new Set());
    return solutions;
};


/**
 * @param {number[]} nums
 * @param {number[][]} solutions
 * @param {number[]} current
 * @param {Set} used
 */
function findPermutations(nums, solutions, current, used) {
  if (current.length === nums.length) {
    return solutions.push(current.slice());
  }

  for (let i = 0; i < nums.length; i++) {
    if (used.has(i)) {
      continue;
    }

    // If current matches previous, only continue if previous is used
    if (i > 0 && nums[i] === nums[i - 1] && !used.has(i - 1)) {
      continue;
    }

    current.push(nums[i]);
    used.add(i);
    findPermutations(nums, solutions, current, used);
    current.pop();
    used.delete(i);
  }
}