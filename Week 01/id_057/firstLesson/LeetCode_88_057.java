package app.homework;

/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (37.11%)
 * Likes:    1357
 * Dislikes: 3170
 * Total Accepted:    433.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 双指针从后向前，比较两个数组的元素
     * 时间复杂度O(m+n)
     * 空间复杂度O(m)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        //如果n<m && len2==-1,就不会拷贝
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    /**
     * 从nums1的m下标位置填充nums2的n个元素，
     * 对nums1的m+n个元素进行排序
     * 可以使用冒泡、插入、选择排序；时间复杂度O(n^2),空间复杂度O(n)
     * 或者使用归并，快速排序；时间复杂度O(nlogn),空间复杂度O(n^2),O(n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge_by_bubbleSort(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        bubbleSort(nums1, m+n);
    }

    /**
     * 冒泡排序
     * @param nums
     * @param size
     */
    public void bubbleSort(int[] nums, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
// @lc code=end

