/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int len1 = 0;
        int len2 = 0;
        int index = 0;
        int [] tmp = new int[m];
        
        System.arraycopy(nums1, 0, tmp, 0, m);
        while (len1 < m && len2 < n) {
            nums1[index++] = tmp[len1] < nums2[len2] ? tmp[len1++] : nums2[len2++];
        }
        if (len1 < m) {
            System.arraycopy(tmp, len1, nums1, len1 + len2, m + n - len1 - len2);
        } 
        
        if(len2 < n){
            System.arraycopy(nums2, len2, nums1, len1 + len2, m + n - len1 - len2);    
        }
        
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
     // 辅助变量len1, len2 是为了方便执行--操作，省代码行数。
        int len1 = m-1;
        int len2 = n-1;
        int index = m + n - 1;
        
        /**
         * 1. 使用>=0, 才能执行到0位置
         * 2. 不能使用Math.max(nums1[len1--], nums2[len2--]), 这样每次len1--, len2--都会执行。
         */
        while (len1 >= 0 && len2 >= 0) {
            nums1[index--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }

        /**
         * 1. 本应该为 if (len1>=0) {} else if(len2>=0){}
         * 2. len1>=0, 则nums1不需要更改，直接在nums1中更改的。
         * 3. len2>=0, 需要将num2中剩余的copy到nums1中。
         * 4. len2>=0, 有while循环可以保证lens2>=-1，则len2+1>=0，可以正常运行arrayCopy().
         **/
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
}
// @lc code=end

