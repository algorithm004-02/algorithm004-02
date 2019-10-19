/**
 * Created by kaiyun on 2019/10/18.
 */
public class MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] nums1_copy = new int[m];
//        System.arraycopy(nums1,0, nums1_copy, 0, m);
//
//        int p1 = 0;
//        int p2 = 0;
//        int p = 0;
//        while ((p1 < m) && (p2 < n)) {
//            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2 ++];
//        }
//        if (p1 < m) {
//            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
//        }
//
//        if (p2 < n) {
//            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
//        }

        // 双指针，从后往前的思想，怎么定义指针位置？选用while循环去遍历指针为什么会更高。
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n -1;

        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);


    }
}
