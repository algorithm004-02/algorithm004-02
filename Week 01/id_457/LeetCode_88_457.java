class Solution {
    // //依靠Java类库，两行代码式
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     System.arraycopy(nums2, 0, nums1, m, n);
    //     Arrays.sort(nums1);
    // }


    /**双指针 / 从前往后*/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p = 0;   //记录nums1的元素下标位置
        int p1 = 0;  //记录nums1_copy的元素下标位置
        int p2 = 0;  //记录nums2的元素下标位置

        while ((p1 < m) && (p2 < n)) {
            //取出最小的，并且最小的index+1
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        // 以下两个if,有且只有一个会执行
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
}