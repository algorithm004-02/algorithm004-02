// https://leetcode-cn.com/problems/merge-sorted-array/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 > -1 && p2 > -1) {
            int larger = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            nums1[p--] = larger;
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}