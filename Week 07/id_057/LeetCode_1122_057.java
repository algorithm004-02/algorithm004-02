package app.homeworkWeekSeventh;

/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 *
 * https://leetcode.com/problems/relative-sort-array/description/
 *
 * algorithms
 * Easy (66.17%)
 * Likes:    302
 * Dislikes: 22
 * Total Accepted:    30.6K
 * Total Submissions: 46K
 * Testcase Example:  '[2,3,1,3,2,4,6,7,9,2,19]\n[2,1,4,3,9,6]'
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all
 * elements in arr2 are also in arr1.
 * 
 * Sort the elements of arr1 such that the relative ordering of items in arr1
 * are the same as in arr2.  Elements that don't appear in arr2 should be
 * placed at the end of arr1 in ascending order.
 * 
 * 
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * 
 * 
 * Constraints:
 * 
 * 
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return relativeSortArray_countingSort(arr1, arr2);
    }

    /**
     * 因为数据量<=1000,因此使用计数排序实现
     * Time O(1)
     * Space O(1)
     * @param arr1
     * @param arr2
     * @return
     */
    private int[] relativeSortArray_countingSort(int[] arr1, int[] arr2) {
        int [] countArr = new int [1001];
        for (int i : arr1) countArr[i] ++;
        int index = 0;
        for (int i : arr2) {
            while (countArr[i] -- > 0) {
                arr1[index++] = i;
            }
        }

        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] -- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
// @lc code=end

