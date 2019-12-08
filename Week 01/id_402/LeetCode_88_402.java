//从后往前(操作繁琐，需要进行优化 边界的判断，简化代码

public void merge(int[] nums1, int m, int[] nums2, int n) {
    int last = n + m - 1;
    while (m > 0 && n > 0){
        if (nums1[m - 1] > nums2[n - 1]){
            nums1[last--] = nums1[m - 1];
            m--;
        } else {
            nums1[last--] = nums2[n - 1];
            n--;
        }
    }
    if (m > 0) {
        while (m > 0) {
            nums1[last--] = nums1[m - 1];
            m--;
        }
    } else {
        while (n > 0) {
            nums1[last--] = nums2[n - 1];
            n--;
        }
    }
}
