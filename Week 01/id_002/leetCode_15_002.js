/** 三数之和 **/
// a + b = -c
// 1. 暴力解法 n^3 三层遍历查找 
// 2. hashMap n^2 两层遍历 
// 3. 排序 + 双指针

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum1 = function(nums) {
  // 去重
  let set = new Set();
  let res = [];
  for(var i = 0; i < nums.length - 2; i ++) {
    for(var j = i + 1; j < nums.length  -1; j ++) {
      for(var k = j + 1; k < nums.length; k ++) {
        var sort = [nums[i], nums[j], nums[k]].sort();
        var key = sort.join(',');
        if (nums[i] + nums[j] + nums[k] === 0 && !set.has(key)) {
          res.push(sort);
          set.add(key)
        }
      }
    }
  }

  return res;
};

// 未AC
var threeSum3 = function(nums) {
  let res = []
  let hash = {}
  for (let i = 0; i < nums.length - 2; i++) { // 每个人
    for (let j = i + 1; j < nums.length - 1; j++) { // 依次拉上其他每个人
      if (hash[nums[j]] !== undefined) { // 已经有合适自己的两人组
        res.push([nums[j]].concat(hash[nums[j]]))
        hash[nums[j]] = undefined
      } else { // 没有合适自己的两人组
        let mark = 0 - nums[i] - nums[j]
        hash[mark] = [nums[i], nums[j]]
      }
    }
  }
  return res
}

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
  let res = [];
  nums.sort((a, b) => a - b);

  for(let k = 0; k < nums.length - 2; k ++) {
    if (nums[k] > 0) break;
    if (k > 0 && nums[k] === nums[k - 1]) continue;

    let i = k + 1;
    let j = nums.length - 1;
    while(i < j) {
      let s = nums[k] + nums[i] + nums[j];
      if (s < 0) {
        i += 1
        while(i < j && nums[i] === nums[i - 1]) i += 1;
      } else if (s > 0) {
        j -= 1;
        while(i < j && nums[j] === nums[j + 1]) j -= 1;
      } else {
        res.push([nums[k], nums[i], nums[j]]);
        i += 1;
        j -= 1;
        
        while(i < j && nums[i] === nums[i - 1]) i += 1;
        while(i < j && nums[j] === nums[j + 1]) j -= 1;
      }
    }
  }

  return res;
}
