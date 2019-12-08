/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (45.52%)
 * Likes:    329
 * Dislikes: 0
 * Total Accepted:    77.2K
 * Total Submissions: 169.6K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        planA(nums1,m,nums2,n);
    }

    public void planA(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums1= new int[m];
        System.arraycopy(nums1, 0, newNums1, 0, m);
        int p=0;
        int p1=0;
        int p2=0;
        while(p1<m&&p2<n){
           if(newNums1[p1] > nums2[p2]){
               nums1[p]=nums2[p2];
               p2++;
            }else{
               nums1[p]=newNums1[p1];
               p1++;
            } 
            p++;
        }
        //当一个数组循环结束，那么剩下的p来自于另一个数组剩下的部分
        if (p1 < m){
            System.arraycopy(newNums1, p1, nums1, p, m + n - p);
        }
        if (p2 < n){
            System.arraycopy(nums2, p2, nums1, p, m + n - p);
        }
    }

}
// @lc code=end

