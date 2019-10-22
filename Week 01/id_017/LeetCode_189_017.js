
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    //https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
    //方法一  暴力解法 最简单的方法是旋转 k 次，每次将数组旋转 1 个元素
    //时间复杂度  O(n*k)   空间复杂度 O(1)
    
    //方法二 使用额外空间 把它们都按照正确顺序放到新的数组中
    //时间复杂度O(n)  空间复杂度O(n)
    
    //方法三 反转法
    //时间复杂度O(n)  空间复杂度O(n)
    // k%= nums.length;
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);

}

function reverse(nums,start,end) {
    while (start < end) {
            let temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
}