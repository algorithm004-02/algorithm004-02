/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
    let n = nums.length
    if (n == 0) {
        return 0
    }
    let dp = new Array(n).fill(1)
    let max = 0
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
        max = Math.max(max, dp[i])
    }
    return max
};


var lengthOfLIS = function (nums) {
    let n = nums.length
    if (n <= 1) {
        return n
    }
    let tail = new Array(n)
    let end = 0
    for (let i = 0; i < n; i++) {
        let left = 0
        let right = end
        while(left < right){
            let mid = (left + right) >> 1;
            if (tail[mid] < nums[i]){
                left = mid + 1
            }else {
                right = mid
            }
        }
        tail[left] = nums[i]
        end == right && end ++
    }
    return end
};

