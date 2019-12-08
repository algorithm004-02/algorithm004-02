class Solution {
    public int reversePairs(int[] nums) {
        
        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);


        
    }
    
    public int mergeSort(int[] nums, int[] temp, int l, int r) {
        if (l >= r) return 0;
        int m = l + ((r - l) >> 1);
        // 先加上左右子数组的结果
        int res = mergeSort(nums, temp, l, m) + mergeSort(nums, temp, m + 1, r);
        // 然后记录左右子数组之间的结果
        int tl = l;
        int tr = m + 1;
        while (tl <= m && tr <= r) {
            // 转为long防止溢出
            if ((long)nums[tl] > 2 * (long)nums[tr]) {
                res += m - tl + 1;
                ++tr;
            } else {
                ++tl;
            }
        }
        // 进行归并
        int ind = 0;
        tl = l;
        tr = m + 1;
        while (tl <= m && tr <= r) {
            if (nums[tl] <= nums[tr]) {
                temp[ind++] = nums[tl++];
                
            } else {
                temp[ind++] = nums[tr++];
            }
        }
        while (tl <= m) temp[ind++] = nums[tl++];
        while (tr <= r) temp[ind++] = nums[tr++];
        // 从临时数组复制到排序数组
        for (int i = l; i <= r; ++i) {
            nums[i] = temp[i - l];
        }
        return res;
    }


}