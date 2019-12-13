class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + ((end - start) / 2);
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        int[] temp = new int[end - start + 1];
        int size = 0;
        int i = start, t = start;
        for (int j = mid + 1; j <= end; j++) {
            while (i <= mid && nums[i] < (long) nums[j] * 2 + 1) i++;
            while (t <= mid && nums[t] < nums[j]) temp[size++] = nums[t++];
            temp[size++] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) {
            temp[size++] = nums[t++];
        }
        if (size >= 0) {
            System.arraycopy(temp, 0, nums, start, size);
        }
        return count;
    }
}

