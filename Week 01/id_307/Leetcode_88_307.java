// 1.移数字插入
// 2.合并，排序
// 3.双指针
// https://leetcode-cn.com/problems/merge-sorted-array/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mlast = m - 1, nlast = n - 1, rlast = m + n -1;
        while (mlast > -1 && nlast > -1) {
            if (nums1[mlast] > nums2[nlast]) {
                nums1[rlast] = nums1[mlast];
                mlast--;
            } else {
                nums1[rlast] = nums2[nlast];
                nlast--;
            }
            rlast--;
        }
        System.arraycopy(nums2, 0, nums1, 0, nlast + 1);
    }
}