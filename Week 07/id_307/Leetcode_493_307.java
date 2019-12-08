class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    private void merge(int[] nums, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, pos = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[pos++] = nums[i++];
            } else {
                temp[pos++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[pos++] = nums[i++];
        }
        while (j <= end) {
            temp[pos++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, begin, end - begin + 1);
    }
    private int mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return 0;
        }
        int mid = begin + ((end - begin) >> 2);
        int result = mergeSort(nums, begin, mid) + mergeSort(nums, mid + 1, end);
        for (int i = begin, j = mid + 1; i <= mid; i++) {
            while (j <= end && (nums[i] > nums[j] * 2l)) j++;
            result += j - (mid + 1);
        }
        merge(nums, begin, mid, end);
        return result;
    }
}