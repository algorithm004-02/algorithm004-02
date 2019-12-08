/**
 * 翻转对
 */
class Solution {
    public int reversePairs(int[] nums) {
        return mergeCount(nums,0,nums.length - 1);
    }

    private int mergeCount(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + ((end - start) >> 1);
        int c1 = mergeCount(nums,start,mid);
        int c2 = mergeCount(nums,mid + 1,end);
        return c1 + c2 + merge(nums,start,mid,end);
    }

    private int merge(int[] nums, int start, int mid, int end) {
        int count = 0;
        //因为前后2个子数组都是有序的。只要前面数组对后面有一个m满足(long)nums[m] <= 2 * (long)nums[n]。
        //那么 n 到 end 的数组对m来说都满足该条件。所以 count + = mid - m + 1;
        for(int m = start, n = mid + 1; n <= end; n++){
            while (m <= mid && (long)nums[m] <= 2 * (long)nums[n]) {
                m++;
            }
            if (m > mid) {
                break;
            }
            count += mid - m + 1;
        }

        //标准的归并排序。在当前段内有序，并赋值给原数组
        int[] temp = new int[end - start + 1];
        int i = start,j = mid + 1,k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (int v = 0; v < temp.length; v++) {
            nums[start + v] = temp[v];
        }
        return count;
    }
}