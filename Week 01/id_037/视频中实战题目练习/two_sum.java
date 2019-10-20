// https://leetcode-cn.com/problems/two-sum/
// 暴力法 遍历！
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ( target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("no results found");
    }
}

// 双指针，从数组两端开始夹逼
// 当双指针的和小于target时，更新i 与 j 所对应的元素的小的一方的指针
// 当双指针的和大于target时，更新i 与 j 所对应的元素的大的一方的指针

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// todo: 解法错误，有待改正!!!!!!!!
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            if (target > nums[i] + nums[j]) {
                if (nums[i] < nums[j]) {
                    i++;
                } else {
                    j--;
                }
            } else if (target < nums[i] + nums[j]) {
                if (nums[i] < nums[j]) {
                    j--;
                } else {
                    i++;
                }
            } else {
                return new int[] {i, j};
            }
        }
        throw new IllegalArgumentException("no results found");
    }
}