class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            for (int j = 0; j < n; j++) {
                nums1[j] = nums2[j];
            }
        } else if (nums1[m - 1] < nums2[0]) {
            for (int i = m; i < m + n; i++) {
                nums1[i] = nums2[i - m];
            }
        } else if (nums1[0] > nums2[n - 1]) {
            for (int i = n; i < m + n; i++) {
                nums1[i] = nums1[i - n];
            }
            for (int j = 0; j < n; j++) {
                nums1[j] = nums2[j];
            }
        } else {
            for (int i = m; i < m + n; i++) {
                nums1[i] = nums2[i - m];
            }
            Arrays.sort(nums1);
        }
    }
}