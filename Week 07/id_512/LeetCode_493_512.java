package WEEK6.LeetCode.Sort;

import java.util.Arrays;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内

 */
public class ReversePairs_493 {
    /*************************************/
    public int reversePairs(int[] nums) {
        return reversePairsSub(nums, 0, nums.length - 1);
    }

    private int reversePairsSub(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int m = l + ((r - l) >> 1);
        int res = reversePairsSub(nums, l, m) + reversePairsSub(nums, m + 1, r);

        int i = l, j = m + 1, k = 0, p = m + 1;
        int[] merge = new int[r - l + 1];

        while (i <= m) {
            while (p <= r && nums[i] > 2L * nums[p]) p++;
            res += p - (m + 1);

            while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }

        while (j <= r) merge[k++] = nums[j++];

        System.arraycopy(merge, 0, nums, l, merge.length);

        return res;
    }

    /*************************************/
    public int reversePairs2(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0;
        int mid = s + (e-s)/2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }
        Arrays.sort(nums, s, e+1);
        return cnt;
    }
    /*************************************/
    //I think because it may not be a balanced tree, his solution maybe not strictly O(nlogn), but merge sort can do it with worst case time complexity in O(nlogn)
    public int reversePairs3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort3(nums, 0, nums.length - 1);
    }
    private int mergeSort3(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l)/2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        int[] cache = new int[r - l + 1];
        int i = l, t = l, c = 0;
        for (int j = mid + 1; j <= r; j++, c++) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache, 0, nums, l, r - l + 1);
        return count;
    }

    /*************************************/
    public class Solution {

        public int ret;
        public int reversePairs(int[] nums) {
            ret = 0;
            mergeSort(nums, 0, nums.length-1);
            return ret;
        }

        public void mergeSort(int[] nums, int left, int right) {
            if (right <= left) {
                return;
            }
            int middle = left + (right - left)/2;
            mergeSort(nums, left, middle);
            mergeSort(nums,middle+1, right);

            //count elements
            int count = 0;
            for (int l = left, r = middle+1; l <= middle;) {
                if (r > right || (long)nums[l] <= 2*(long)nums[r]) {
                    l++;
                    ret += count;
                } else {
                    r++;
                    count++;
                }
            }

            //sort
            Arrays.sort(nums, left, right + 1);
        }
    }
}
