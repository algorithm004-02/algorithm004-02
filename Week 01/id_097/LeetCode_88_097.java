
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;

        // nums1尾部扩展出空间，感觉跟扩展出第三方空间差不多
        int p = m + n - 1;

        while ((p1 >= 0) && (p2 >= 0)) {

            // 大的放后面
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        // 如果nums2有多余的元素，拼接到nums1前面（此时nums1前面的元素已经排到后面了）
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
