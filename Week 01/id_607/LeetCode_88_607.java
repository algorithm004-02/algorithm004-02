class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //compare from the end 
        int p1 = m - 1;
        int p2 = n - 1;
        //target array's end is m+n-1
        int p = m + n - 1;

        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
            p--;
        }
      // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}