/**
     * 整合两个有序的数组成一个有序的数组
     *
     * @param nums1 有序数组1
     * @param nums2 有序数组2
     * @return 两个数组整合之后的有序数组
     */
    public static int[] assembleSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        if (i < 0 && j >= 0) {
            nums1 = nums2;
        }
        return nums1;
    }