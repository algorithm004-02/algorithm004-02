//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        //思路：使用归并排序的方式解决此题
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = start + ((end - start) / 2);
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        int[] temp = new int[end - start + 1];
        int size = 0;
        int i = start, t = start;
        for (int j = mid + 1; j <= end; j++) {
            //一定要转化为long类型之后在进行乘法，不然对大整数会因溢出而导致结果错误
            while (i <= mid && nums[i] < (long) nums[j] * 2 + 1) i++;
            while (t <= mid && nums[t] < nums[j]) temp[size++] = nums[t++];
            temp[size++] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) temp[size++] = nums[t++];
        for (int j = 0; j < size; j++) {
            nums[start + j] = temp[j];
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
